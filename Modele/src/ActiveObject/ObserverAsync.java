package ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public interface ObserverAsync<T> {

    Future<Void> update() throws ExecutionException, InterruptedException;
    Future<Integer> getValue();
    ScheduledExecutorService getScheduler();
}
