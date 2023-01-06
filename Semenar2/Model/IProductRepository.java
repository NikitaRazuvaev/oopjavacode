package Semenar2.Model;

import java.util.List;

public interface IProductRepository {
    IProduct create(IProduct product);
    IProduct get(int id);
    IProduct update(IProduct product);
    boolean delete(IProduct product);

    List<IProduct> getProductByAvtomatID(int avtomatID);
}
