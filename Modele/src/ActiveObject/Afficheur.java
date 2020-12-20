package ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Afficheur<Capteur> implements ObserverAsync {
	
	private Capteur capteur;
	private Canal canal;
	private int value;

	
    public Afficheur(Capteur capteur){
        this.capteur = capteur;
    }
    public Canal getCanal() {
    	return canal;
    }

    public void setCanal(Canal canal) {
    	this.canal = canal;
    }

	@Override
	public Void update(ActiveObject.Capteur subject) throws ExecutionException, InterruptedException {
        this.value = this.canal.getValue().get();
		return null;
	}

}
