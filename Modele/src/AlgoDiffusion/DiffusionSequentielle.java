package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Algorithme de Diffusion Sequentielle
 */
public class DiffusionSequentielle implements AlgoDiffusion{
    private Capteur capteur;
    private List<Canal> canaux = new ArrayList<>();
    private List<Future> listeFuture = new ArrayList<>();

    /**
     * Configure l'algorithme
     * @param capteur
     * @param canaux
     */
    @Override
    public void configure(Capteur capteur, List<Canal> canaux) {
        this.capteur = capteur;
        this.canaux = canaux;
    }

    /**
     * Execute les update des Canaux
     */
    @Override
    public void execute() {
        if(futuresDone()){
            this.listeFuture = new ArrayList<>();
            for (Canal canal : canaux){
                listeFuture.add(canal.update());
            }
        }
    }

    /**
     * Getter de value de Capteur
     * @param canal
     * @return Capteur value
     */
    @Override
    public int getValue(Canal canal) throws InterruptedException {
        return capteur.getValue();
    }

    /**
     * Getter des canaux
     * @return List<Canal>
     */
    @Override
    public List<Canal> getCanalList() {
        return this.canaux;
    }

    /**
     * Vérifie si les Futures des Canaux ont été réalisé
     * @return result
     */
    public boolean futuresDone(){
        boolean result = true;
        for(Future future : listeFuture){
            result &= future.isDone();
        }
        return result;
    }


}
