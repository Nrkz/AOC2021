package ActiveObject;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Afficheur{
	
	List<Integer> values;
	int id;

	
    public Afficheur(int id){
        this.id = id;
    }

	public Void update(Canal canal) throws ExecutionException, InterruptedException {
        Future<Integer> val = canal.getValue();
        System.out.println("Afficheur "+ id +" value : " + val.get());
        values.add(val.get());
        return null;
	}

	public List<Integer> getValues(){
        return this.values;
    }

}
