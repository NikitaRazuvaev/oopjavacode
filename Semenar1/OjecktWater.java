package oopjavacode.Semenar1;

public class OjecktWater extends Product{
    OjecktWater(int massa, int price){
        super(1,"whate",price,massa);
    }
    
@Override
public String toString() {
    
    return  String.format("Это вода(id = %d),по цене(%d), и массой(%d)", getId(),getPrice(),getMassa());
}

}