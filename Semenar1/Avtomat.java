package oopjavacode.Semenar1;

import java.util.ArrayList;

public class Avtomat {
    private int id;
    private int size;
    private int price;
    protected ArrayList<Product> products;

    public Avtomat(int id, int saiz, int price, ArrayList<Product> products){
        this.id = id;
        this.size= saiz;
        this.price = price;
        this.products = products;

    }
    public Avtomat(int id){
        this.id = id;
    }
    public int getId (){
        return id;
    }
    public int getSize (){
        return size;
    }
    public int getPrice (){
        return price;
    }
    public void setPrice(int value ) {
        this.price = value;
    }
    public void setSize(int value){
        this.size = value;
    }
    public void setId(int value) {
        this.id = value;
    }
    /**
     * @param id
     * @return
     */
    public Product getProduct(int id){
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i); 
            if (id == product.getId()) {
             return products.get(i);
            }
          }
        return null;
    }

    

    public Product getProduct(String name){
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i); 
           if (name == product.getName()) {
            return products.get(i);
           }
         }
        return null;
    }

    public Product getProduct(String name,int massa){
        for (int i = 0; i < products.size(); i++) {
           Product product = products.get(i); 
            if (name == product.getName() && massa == product.getMassa()) {
            return products.get(i);
           }
         }
        return null;
    }
}
