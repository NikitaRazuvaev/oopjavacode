package oopjavacode.Semenar1;

public class HotDrink extends Product {
    private int temp;
   
    public int getTemp() {
       return temp;
   }
   public void setTemp(int temp) {
       this.temp = temp;
   }
    HotDrink(int massa,int price, int temp){
        super(2,"HotCoffee",price,massa);
        this.temp = temp;
    }
    @Override
public String toString() {
    
    return  String.format("Это горячий напиток(id = %d),по цене(%d), и массой(%d) и температурой: (%d)", getId(),getPrice(),getMassa(),temp);
}

   

}

