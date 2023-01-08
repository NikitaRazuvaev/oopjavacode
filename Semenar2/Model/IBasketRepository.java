package Semenar2.Model;

import java.util.Collection;

public interface IBasketRepository{
    IBasket create(IBasket basket);
    IBasket get(int id);
    IBasket update(IBasket basket);
    boolean delete(IBasket basket);

    Collection<IBasket> getAll();
    IBasket getOrCreateForUser(IUser user);

}