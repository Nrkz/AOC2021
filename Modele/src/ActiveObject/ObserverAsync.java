package ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface ObserverAsync {

    Void update(Capteur subject) throws ExecutionException, InterruptedException;

}
