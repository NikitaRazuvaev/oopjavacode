package oopjavacode.Semenar1;

import java.util.ArrayList;

public class HotDrinksAvtomat extends Avtomat {
    
    public HotDrinksAvtomat(int id, int size, int price, ArrayList<Product> products){
        super(id,size,price,products);
    }
    
    public Product getProduct(String name, int massa, int temp) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product instanceof HotDrink) {
                HotDrink drink = (HotDrink)product;
            
            if (name == drink.getName() && temp == drink.getTemp()) {
             return drink;
            }
        }  
        }
         return null;    
    }
}
