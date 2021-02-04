package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;
import ActiveObject.ObserverAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Algorithme de Diffusion Sequentielle
 */
public class DiffusionSequentielle implements AlgoDiffusion{
    private Capteur capteur;
    private Set<ObserverAsync> canaux;
    private List<Future> listeFuture = new ArrayList<>();

    /**
     * Configure l'algorithme
     * @param capteur capteur
     */
    @Override
    public void configure(Capteur capteur) {
        this.capteur = capteur;
        this.canaux = capteur.getObservers();
    }

    /**
     * Execute les update des Canaux
     */
    @Override
    public void execute() throws ExecutionException, InterruptedException {
        if(futuresDone()){
            this.listeFuture = new ArrayList<>();
            for (ObserverAsync canal : canaux){
                listeFuture.add(canal.update());
            }
        }
    }

    /**
     * Getter des canaux
     * @return HashSet
     */
    @Override
    public Set<ObserverAsync> getCanalList() {
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
