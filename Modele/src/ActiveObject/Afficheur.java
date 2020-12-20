package ActiveObject;

import java.util.concurrent.Future;

public class Afficheur<Capteur> implements ObserverAsync {
	
	private Capteur capteur;
	private Canal canal;

	
    public Afficheur(Capteur capteur){
        this.capteur = capteur;
    }
    public Canal getCanal() {
    	return canal;
    }
    public void setCanal(Canal canal) {
    	this.canal = canal;
    }
    public void update(){

    }

	@Override
	public Future<Void> update(ActiveObject.Capteur subject) {
		// TODO Auto-generated method stub
		return null;
	}

}
