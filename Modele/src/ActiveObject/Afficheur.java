package ActiveObject;

import java.util.concurrent.Future;

public class Afficheur<CapteurImpl> implements ObserverAsync {

    private Capteur subject;
    private Canal canal;

    public Afficheur(int id){
        this.id = id;
    }

    public void update(){

    }


    @Override
    public Future<Void> update(ActiveObject.Capteur subject) {
        return null;
    }
}
