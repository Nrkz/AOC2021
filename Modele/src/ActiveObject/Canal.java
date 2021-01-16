package ActiveObject;

import AlgoDiffusion.AlgoDiffusion;

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
    private AlgoDiffusion algo;
    private List<ObserverAsync> observers = new ArrayList<ObserverAsync>();

    public Canal(CapteurImpl capteur, ScheduledExecutorService scheduler, Afficheur afficheur, AlgoDiffusion algo){
        this.capteur = capteur;
        this.scheduler = scheduler;
        this.afficheur = afficheur;
        this.algo = algo;
    }


    public Future<Void>  update() {
        Callable<Void> update= () -> afficheur.update(this);
        return scheduler.schedule(update, randomDelay(), TimeUnit.MILLISECONDS);
    }

    public Future<Integer> getValue() {
        Callable<Integer> getValue = () -> this.algo.getValue(this);
        return scheduler.schedule(getValue, randomDelay(), TimeUnit.MILLISECONDS);
    }


    private int randomDelay() {
        return new Random().nextInt(1000-500 +1) +1;
    }

    public ScheduledExecutorService getScheduler() {
        return scheduler;
    }
}
