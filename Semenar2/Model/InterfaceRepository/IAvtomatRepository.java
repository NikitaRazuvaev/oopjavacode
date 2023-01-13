package Semenar2.Model.InterfaceRepository;

import java.util.Collection;

import Semenar2.Model.Interface.IAvtomat;

public interface IAvtomatRepository {
    IAvtomat create(IAvtomat avtomat);
    IAvtomat get(int id);
    IAvtomat update(IAvtomat avtomat);
    boolean delete(IAvtomat avtomat);


    Collection<IAvtomat> getAll();
    
}
