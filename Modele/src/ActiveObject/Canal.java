package ActiveObject;

import AlgoDiffusion.AlgoDiffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * La classe Canal
 */
public class Canal implements CapteurAsync,ObserverAsync {

    private CapteurImpl capteur;
    private Afficheur afficheur;
    private ScheduledExecutorService scheduler;
    private AlgoDiffusion algo;
    private List<ObserverAsync> observers = new ArrayList<ObserverAsync>();

    /**
     * Constructeur de Canal
     * @param capteur
     * @param scheduler
     * @param afficheur
     * @param algo
     */
    public Canal(CapteurImpl capteur, ScheduledExecutorService scheduler, Afficheur afficheur, AlgoDiffusion algo){
        this.capteur = capteur;
        this.scheduler = scheduler;
        this.afficheur = afficheur;
        this.algo = algo;
    }


    /**
     * Met à jour l'Afficheur en lançant l'exécution d'un ScheduledExecutorService
     * @return Future<Void>
     */
    public Future<Void>  update() {
        Callable<Void> update= () -> afficheur.update(this);
        return scheduler.schedule(update, randomDelay(), TimeUnit.MILLISECONDS);
    }

    /**
     * Récupère la valeur du capeur en lançant l'exécution d'un ScheduledExecutorService
     * @return Future<Integer>
     */
    public Future<Integer> getValue() {
        Callable<Integer> getValue = () -> this.algo.getValue(this);
        int random = randomDelay();
        return scheduler.schedule(getValue,random , TimeUnit.MILLISECONDS);
    }


    /**
     * @return un int aléatoire
     */
    private int randomDelay() {
        return (int) 375 + (int)(Math.random() * ((600 - 400) + 1));
    }

    /**
     * Getter de scheduler
     * @return scheduler
     */
    public ScheduledExecutorService getScheduler() {
        return scheduler;
    }
}
