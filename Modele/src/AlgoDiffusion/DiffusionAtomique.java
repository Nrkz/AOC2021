package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.List;

public class DiffusionAtomique implements AlgoDiffusion{
    public void configure(Capteur capteur, List<Canal> canaux) {

    }

    @Override
    public void execute() {

    }

    @Override
    public void readValue(CapteurImpl c) {

    }

    @Override
    public List<Canal> getCanalList() {
        return null;
    }
}
