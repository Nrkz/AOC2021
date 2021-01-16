package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DiffusionEpoque implements AlgoDiffusion{

    private Capteur capteur;
    private List<Canal> canaux = new ArrayList<>();

    @Override
    public void configure(Capteur capteur, List<Canal> canaux) {
        this.capteur = capteur;
        this.canaux = canaux;
    }

    @Override
    public void execute() {
        for(Canal canal : canaux){
            canal.update();
        }
    }

    @Override
    public int getValue(Canal canal) throws ExecutionException, InterruptedException {
        lock(canal);
        return capteur.getValue();
    }

    @Override
    public List<Canal> getCanalList() {
        return canaux;
    }

    public void lock(Canal canal){
        canal.update();
    }
}
