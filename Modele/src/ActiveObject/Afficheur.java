package ActiveObject;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Afficheur{
	
	private Canal canal;
	List<Integer> values;
	String id;

	
    public Afficheur(Canal canal){
        this.canal = canal;
    }

	public Future<Void> update(Capteur capteur) throws ExecutionException, InterruptedException {
        Future<Integer> val = canal.getValue();
        System.out.println("Afficheur "+ id +" value : "+val);
        values.add(val.get());
        return null;
	}

}
