package oopjavacode.Semenar1;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Product> hotDrinks = new ArrayList<Product>();
        hotDrinks.add(new HotDrink(350, 10, 450));
        hotDrinks.add(new HotDrink(280, 125, 45));
        hotDrinks.add(new HotDrink(250, 15, 10));
        hotDrinks.add(new HotDrink(400, 70, 40));
        hotDrinks.add(new HotDrink(600, 80, 50));
        hotDrinks.add(new HotDrink(1000, 90, 90));
        hotDrinks.add(new HotDrink(1500, 100, 80)); 
    
    HotDrinksAvtomat avtomat = new HotDrinksAvtomat(1010, 100, 0, hotDrinks);
    System.out.println(avtomat.getProduct(0));// return null
    System.out.println(avtomat.getProduct("Вода")); // return null
    System.out.println(avtomat.getProduct("HotCoffee", 400));
    System.out.println(avtomat.getProduct("HotCoffee", 350, 450));
    
    }
    
}
