package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;
import ActiveObject.ObserverAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Algorithme de Diffusion Epoque
 */
public class DiffusionEpoque implements AlgoDiffusion{

    private Set<ObserverAsync> canaux;

    /**
     * Configure l'algorithme
     * @param capteur capteur
     */
    @Override
    public void configure(Capteur capteur) {
        this.canaux = capteur.getObservers();
    }

    /**
     * Execute les update des Canaux
     */
    @Override
    public void execute() throws ExecutionException, InterruptedException {
        for(ObserverAsync canal : canaux){
            canal.update();
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

}
