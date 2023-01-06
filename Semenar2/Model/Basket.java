package Semenar2.Model;

import java.util.Collection;

/**
 * Basket
 */
public class Basket implements IBasket{

    private int id; 
    private IUser user;
    private Collection<IProduct> products;
    private boolean ispaid;
    private String code;

    public Basket(int id, IUser user, Collection<IProduct> products, boolean ispaid, String code){
        this.id = id;
        this.user = user;
        this.products = products;
        this.ispaid = ispaid;
        this.code = code;

    }
    public Basket(int id, IBasket basket){
        this.id = id;
        this.user = basket.getUser();
        this.products = basket.getProducts();
        this.ispaid = basket.isPaid();
        this.code = basket.getCode();

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public Collection<IProduct> getProducts() {
        return products;
    }

    @Override
    public boolean isPaid() {
        return ispaid;
    }

    @Override
    public String getCode() {
        return code;
    }
 
    
}