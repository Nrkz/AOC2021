package ActiveObject;

import AlgoDiffusion.AlgoDiffusion;

import java.util.concurrent.ExecutionException;

/**
 * La classe Capteur
 */
public class CapteurImpl implements  Capteur{

    private int value;
    private AlgoDiffusion algoD;
    public boolean lock;


    /**
     * Constructeur de CapteurImpl
     * @param algo
     */
    public CapteurImpl(AlgoDiffusion algo){
        this.value = 0;
        this.algoD = algo;
        this.lock = false;
    }

    /**
     * Change la valeur du Capteur et utilise l'algorithme sélectionné pour mettre à jour les différents Canaux
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void tick() throws ExecutionException, InterruptedException{
        if(!isLock()) {
            value++;
            algoD.execute();
        }
    }

    /**
     * Getter de value
     * @return value
     */
    @Override
    public int getValue() {
        return value;
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
     * @param bol
     */
    public void verrou(boolean bol){
        this.lock = bol;
    }

}
