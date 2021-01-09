package ActiveObject;

import java.util.concurrent.ExecutionException;

public interface Capteur {

    public void tick() throws ExecutionException, InterruptedException;

    public int getValue();
}
