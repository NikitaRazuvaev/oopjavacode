package Semenar2.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class ProductRepository implements IProductRepository{
    
    private Map<Integer, IProduct> products;
    public ProductRepository(){
        products = new HashMap<>();
    }
    @Override
    public IProduct create(IProduct product) {
        if (product.getId() == 0){
            int newId = Collections.max(products.keySet()) +1 ;
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
    @Override
    public List<IProduct> getProductByAvtomatID(int avtomatID) {
        List<IProduct> result = new ArrayList<>();
        for (IProduct product : products.values()) {
            if (product.getLocation().getId() == avtomatID) {
                result.add(product);
            }
        }
        return result;
    }
    
}
