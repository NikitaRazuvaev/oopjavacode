package Semenar2.Views;

import java.util.ArrayList;
import java.util.List;

import Semenar2.Model.IBasket;
import Semenar2.Model.IProduct;

public class BasketView {
    public int id;
    public double totalPrice;
    List<ProductView> products;
    
    public BasketView(IBasket basket) {
        this.id = basket.getId();
        this.products = new ArrayList<>();
        this.totalPrice = 0;
        for (IProduct product : basket.getProducts()) {
            totalPrice += product.getPrice();
            this.products.add(new ProductView(product));
        } 
    }
}
