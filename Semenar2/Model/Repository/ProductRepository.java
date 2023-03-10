package Semenar2.Model.Repository;

import java.util.HashMap;
import java.util.Map;

import Semenar2.Model.Product;
import Semenar2.Model.Interface.IProduct;
import Semenar2.Model.InterfaceRepository.IProductRepository;

import java.util.Collection;

public class ProductRepository extends AbstractRepository implements IProductRepository{
    
    private Map<Integer, IProduct> products;
    public ProductRepository(){
        products = new HashMap<>();
    }
    public Collection<IProduct> getAll()  { // Заменить на функцию search с возможностю задания предикатта 
        return products.values();
    }


    @Override
    public IProduct create(IProduct product) {
        if (product.getId() == 0){
            int newId = calculetNextKey(products.keySet());
            IProduct newProduct = new Product(newId, product);
            products.put(Integer.valueOf(newId), newProduct);
            return newProduct;
        }
        return null;
    }
    @Override
    public IProduct get(int id) {
        return products.get(Integer.valueOf(id));
    }
    @Override
    public IProduct update(IProduct product) {
        if(products.containsKey(product.getId())){
            products.remove(product.getId());
            products.put(product.getId(), product);
            return product;
        }
        return null;
    }
    @Override
    public boolean delete(IProduct product) {
        if (products.containsKey(product.getId())) {
            products.remove(product.getId());
            return true;
        }
        return false;
    }
   
}
