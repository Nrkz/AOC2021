package ActiveObject;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Update implements Callable<Void> {

	private Capteur capteur;
	private Afficheur<Capteur> afficheur;
	
    public Update(Afficheur<Capteur> afficheur,Capteur capteur){
        this.afficheur = afficheur;
        this.capteur = capteur;
    }

    @Override
    public Void call() {
        afficheur.update(capteur);
        return null;
    }
}
