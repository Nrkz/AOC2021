package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Algorithme de Diffusion Epoque
 */
public class DiffusionEpoque implements AlgoDiffusion{

    private Capteur capteur;
    private List<Canal> canaux = new ArrayList<>();

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
        for(Canal canal : canaux){
            canal.update();
        }
    }

    /**
     * Getter de value de Capteur
     * @param canal
     * @return Capteur value
     */
    @Override
    public int getValue(Canal canal) throws ExecutionException, InterruptedException {
        return capteur.getValue();
    }

    /**
     * Getter des canaux
     * @return List<Canal>
     */
    @Override
    public List<Canal> getCanalList() {
        return canaux;
    }

}
