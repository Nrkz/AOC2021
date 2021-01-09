package ActiveObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Update implements Callable<Void> {

	private Capteur capteur;
	private Afficheur afficheur;
	
    public Update(Afficheur afficheur,Capteur capteur){
        this.afficheur = afficheur;
        this.capteur = capteur;
    }

    @Override
    public Void call() throws ExecutionException, InterruptedException {
        afficheur.update(capteur);
        return null;
    }
}
