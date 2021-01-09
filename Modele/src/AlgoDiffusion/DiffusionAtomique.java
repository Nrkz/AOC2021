package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.ArrayList;
import java.util.List;

public class DiffusionAtomique implements AlgoDiffusion{

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
            canal.update(canal);
        }
    }

    @Override
    public int readValue() {
        return capteur.getValue();
    }

    @Override
    public List<Canal> getCanalList() {
        return canaux;
    }
}
