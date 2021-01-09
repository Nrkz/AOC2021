package ActiveObject;

import java.util.concurrent.ExecutionException;

public interface Capteur {

    void tick() throws InterruptedException, ExecutionException;;

    int getValue();
}
