package Semenar2.Model;

public class Product implements IProduct{
    private int id;
    private String name;
    private IAvtomat location;
    private double price;
    private boolean best;
    
    public Product(int id, String name, IAvtomat location, double price, boolean isbest){
        this.id = id;
        this.name = name;
        this.location = location; 
        this.price = price;
        this.best = isbest;
    }

    public Product(int id,IProduct product ){
        this.id = id;
        this.name = product.getName();
        this.location = product.getLocation(); 
        this.best = product.isBestProduct();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IAvtomat getLocation() {
        return location;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isBestProduct() {
        return best;
    }
    
}
