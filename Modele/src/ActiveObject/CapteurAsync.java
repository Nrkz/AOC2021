package ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface CapteurAsync {

    void attach(ObserverAsync observer);

    void detach(ObserverAsync observer);

    Future<Integer> getValue() throws ExecutionException, InterruptedException;

    void tick();
}
