package Semenar2.Model.InterfaceRepository;

import java.util.Collection;

import Semenar2.Model.Interface.IBasket;

public interface IBasketRepository{
    IBasket create(IBasket basket);
    IBasket get(int id);
    IBasket update(IBasket basket);
    boolean delete(IBasket basket);

    Collection<IBasket> getAll(); // Заменить на функцию search с возможностю задания предикатта 
}