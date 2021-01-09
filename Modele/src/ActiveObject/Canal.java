package ActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements CapteurAsync,ObserverAsync {

    private Capteur capteur;
    private Afficheur afficheur;
    private ScheduledExecutorService scheduler;
    private List<ObserverAsync> observers = new ArrayList<ObserverAsync>();

    public Canal(CapteurImpl capteur){
        this.capteur=capteur;
    }


    public Future<Integer> getValue(){
        Future future = scheduler.schedule(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                capteur.getValue();
                return null;
            }
        }, 1000,TimeUnit.MILLISECONDS);
        return future;
    }


    public Future<Void> update(Capteur subject) {
        Future future = scheduler.schedule(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                afficheur.update(capteur);
                return null;
            }
        }, 1000,TimeUnit.MILLISECONDS);
        return future;
    }
}
