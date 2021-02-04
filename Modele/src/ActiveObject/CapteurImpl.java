package ActiveObject;

import AlgoDiffusion.AlgoDiffusion;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * La classe Capteur
 */
public class CapteurImpl implements  Capteur{

    private int value;
    private AlgoDiffusion algo;
    public boolean lock;
    Set<ObserverAsync> observers = new HashSet<>();



    /**
     * Constructeur de CapteurImpl
     * @param algo Stratégie de diffusion.
     */
    public CapteurImpl(AlgoDiffusion algo){
        this.value = 0;
        this.algo = algo;
        this.lock = false;

    }

    /**
     * Change la valeur du Capteur et utilise l'algorithme sélectionné pour mettre à jour les différents Canaux
     */
    public void tick() throws ExecutionException, InterruptedException{
        if(!isLock()) {
            value++;
            algo.execute();
        }
    }

    /**
     * Getter de value
     * @return value
     */
    @Override
    public int getValue() {
        this.verrou(false);
        return value;
    }

    /**
     * Attacheur Capteur-Canal
     */
    @Override
    public void attach(ObserverAsync o) {
        observers.add(o);
    }

    /**
     * Détacheur Capteur-Canal
     */
    @Override
    public void detach(ObserverAsync o) {
        observers.remove(o);
    }

    /**
     * Getter des observers du Capteur
     */
    @Override
    public Set<ObserverAsync> getObservers() {
        return this.observers;
    }

    /**
     * Getter de lock
     * @return lock
     */
    public boolean isLock(){
        return this.lock;
    }

    /**
     * Setter de lock
     * @param bol booléen
     */
    public void verrou(boolean bol){
        this.lock = bol;
    }

}
