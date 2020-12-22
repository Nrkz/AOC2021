package ActiveObject;

import java.util.List;
import java.util.concurrent.Future;

public class Afficheur<Capteur> implements ObserverAsync {
	
	private Canal canal;
	int val;
	List<Integer> values;
	String name;

	
    public Afficheur(Canal canal){
        this.canal = canal;
    }

	@Override
	public Future<Void> update(ActiveObject.Capteur capteur) {
        //devra faire appele au canal
        val = capteur.getValue();
        System.out.println(name+" value : "+val);
        values.add(val);
        return null;
	}
}
