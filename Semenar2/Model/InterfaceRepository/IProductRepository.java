package Semenar2.Model.InterfaceRepository;

import java.util.Collection;

import Semenar2.Model.Interface.IProduct;


public interface IProductRepository {
    IProduct create(IProduct product);
    IProduct get(int id);
    IProduct update(IProduct product);
    boolean delete(IProduct product);

    Collection<IProduct> getAll(); // Заменить на функцию search с возможностю задания предикатта 
    
}
