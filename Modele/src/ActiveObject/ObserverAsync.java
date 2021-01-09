package ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface ObserverAsync {

    Future<Void> update(Canal subject) throws ExecutionException, InterruptedException;

}
