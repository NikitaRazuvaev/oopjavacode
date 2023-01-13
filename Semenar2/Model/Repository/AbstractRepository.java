package Semenar2.Model.Repository;

import java.util.Collection;
import java.util.Collections;

public abstract class AbstractRepository {
    public int calculetNextKey(Collection<Integer> keyCollection){
        if (keyCollection == null || keyCollection.size() == 0) {
            return 1;
        }
        return Collections.max(keyCollection) +1; 
        
    }    
}
