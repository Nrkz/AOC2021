package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.List;

public interface AlgoDiffusion {

    void configure(Capteur capteur, List<Canal> canaux);

    void execute();

    int readValue();

    List<Canal> getCanalList();
}
