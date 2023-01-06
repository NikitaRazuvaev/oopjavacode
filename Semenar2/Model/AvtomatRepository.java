package Semenar2.Model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ranges.RangeException;

public class AvtomatRepository implements IAvtomatRepository{
    
    private Map<Integer, IAvtomat> avtomats;
    
    public AvtomatRepository(){
        avtomats = new HashMap<>();
    }

    @Override
    public IAvtomat create(IAvtomat avtomat) {
        if (avtomat.getId()==0){
            int newId = Collections.max(avtomats.keySet()) +1;
            IAvtomat newAvtomat = new Avtomat(newId, avtomat);
            avtomats.put(Integer.valueOf(newId),newAvtomat);
            return newAvtomat;
        }
        if (avtomats.containsKey(avtomat.getId())){
            throw new RangeException((short) 1, String.format("avtomat with id %d is present in repository", avtomat.getId()));
        }
        avtomats.put(Integer.valueOf(avtomat.getId()), avtomat);
        return avtomat;
    }

    @Override
    public IAvtomat get(int id) {
        return avtomats.get(Integer.valueOf(id));
    }

    @Override
    public IAvtomat update(IAvtomat avtomat) {
        if (avtomats.containsKey(avtomat.getId())){
            avtomats.remove(avtomat.getId());
            avtomats.put(avtomat.getId(), avtomat);
            return avtomat;
        }
        return null;
    }

    @Override
    public boolean delete(IAvtomat avtomat) {
        if (avtomats.containsKey(avtomat.getId())){
            avtomats.remove(avtomat.getId());
            return true;
        }
        return false;
    }

    @Override
    public Collection<IAvtomat> getAll() {
        return avtomats.values();
    }
    
}
