package Semenar2.Model;

import java.util.Collection;

public interface IAvtomatRepository {
    IAvtomat create(IAvtomat avtomat);
    IAvtomat get(int id);
    IAvtomat update(IAvtomat avtomat);
    boolean delete(IAvtomat avtomat);


    Collection<IAvtomat> getAll();
    
}
