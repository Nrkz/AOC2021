package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AlgoDiffusion {

    void configure(Capteur capteur, List<Canal> canaux);

    void execute();

    int getValue(Canal canal) throws ExecutionException, InterruptedException;

    List<Canal> getCanalList();
}
