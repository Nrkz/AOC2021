package ActiveObject;

import java.util.concurrent.Future;

public interface ObserverAsync {

    Future<Void> update(Capteur subject);

}
