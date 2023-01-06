package Semenar2.Model;

public interface IBasketRepository{
    IBasket create(IBasket basket);
    IBasket get(int id);
    IBasket update(IBasket basket);
    boolean delete(IBasket basket);

}