package Semenar2.Model;

import java.util.Collection;
import java.util.Collections;

public abstract class AbstractRepository {
    protected int calculetNextKey(Collection<Integer> keyCollection){
        if (keyCollection == null || keyCollection.size() == 0) {
            return 1;
        }
        return Collections.max(keyCollection) +1; 
        
    }    
}
