package Semenar2.Model;

import java.util.Collection;


public interface IProductRepository {
    IProduct create(IProduct product);
    IProduct get(int id);
    IProduct update(IProduct product);
    boolean delete(IProduct product);

    Collection<IProduct> getAll();
    
}
