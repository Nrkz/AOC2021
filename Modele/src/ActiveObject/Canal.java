package ActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements CapteurAsync,ObserverAsync {

    private CapteurImpl capteur;
    private Afficheur afficheur;
    private ScheduledExecutorService scheduler;
    private List<ObserverAsync> observers = new ArrayList<ObserverAsync>();

    public Canal(CapteurImpl capteur, ScheduledExecutorService scheduler, Afficheur afficheur){
        this.capteur = capteur;
        this.scheduler = scheduler;
        this.afficheur = afficheur;
    }


    /*public Future<Integer> getValue(){
        Future future = scheduler.schedule(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                capteur.getValue();
                return null;
            }
        }, randomDelay(),TimeUnit.MILLISECONDS);
        return future;
    }


    public Future<Void> update(Canal subject) {
        Future future = scheduler.schedule(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                afficheur.update(subject);
                return null;
            }
        }, randomDelay(),TimeUnit.MILLISECONDS);
        return future;
    }*/

    public Future<Void>  update() {
        Callable<Void> updateLambda = () -> afficheur.update(this);
        return scheduler.schedule(updateLambda, randomDelay(), TimeUnit.MILLISECONDS);
    }

    public Future<Integer> getValue() {
        Callable<Integer> getValueLambda = () -> this.capteur.getValue();
        return scheduler.schedule(getValueLambda, randomDelay(), TimeUnit.MILLISECONDS);
    }


    private int randomDelay() {
        return new Random().nextInt(1000-500 +1) +1;
    }

    public ScheduledExecutorService getScheduler() {
        return scheduler;
    }
}
