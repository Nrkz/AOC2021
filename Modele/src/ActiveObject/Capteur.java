package ActiveObject;

import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface Capteur {

    void tick() throws InterruptedException, ExecutionException;;

    int getValue();

    void attach(ObserverAsync o);

    void detach(ObserverAsync o);

    Set<ObserverAsync> getObservers();

    void verrou(boolean b);
}
