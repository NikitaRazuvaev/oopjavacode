package Semenar2.Model;

public class Product implements IProduct{
    private int id;
    private String name;
    private IAvtomat location;
    
    public Product(int id, String name, IAvtomat location){
        this.id = id;
        this.name = name;
        this.location = location; 
    }

    public Product(int id,IProduct product ){
        this.id = id;
        this.name = product.getName();
        this.location = product.getLocation(); 
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
    
}