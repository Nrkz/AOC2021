package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;
import ActiveObject.ObserverAsync;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface AlgoDiffusion {

    void configure(Capteur capteur);

    void execute() throws ExecutionException, InterruptedException;

    Set<ObserverAsync> getCanalList();
}
