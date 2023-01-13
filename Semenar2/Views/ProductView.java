package Semenar2.Views;

import Semenar2.Model.Interface.IProduct;

public class ProductView {
    public int id;
    public String name;
    public double price; 

    public ProductView(IProduct product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}