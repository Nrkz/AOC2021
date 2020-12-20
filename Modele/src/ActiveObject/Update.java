package ActiveObject;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

	private Canal canal;
	private Capteur capteur;
	private Afficheur<Capteur> afficheur;
	
    public Update(){

    }

    @Override
    public Void call() throws Exception {
        return this.afficheur.update(capteur);
    }
}
