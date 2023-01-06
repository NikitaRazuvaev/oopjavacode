package Semenar2.Model;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ranges.RangeException;

import java.util.Collections;


public class BasketRepository implements IBasketRepository{

    private Map<Integer, IBasket> baskets;
    public BasketRepository(){
        baskets = new HashMap<>();
    }
    @Override
    public IBasket create(IBasket basket) {
        if (basket.getId() ==0 ){
            int newId = Collections.max(baskets.keySet()) +1 ;
            IBasket newBasket = new Basket(newId, basket);
            baskets.put(Integer.valueOf(newId), newBasket);
            return newBasket;
        }
        if (baskets.containsKey(basket.getId())){
            throw new RangeException((short) 1, String.format("basket with id %d is present in repository", basket.getId()));
        }
        baskets.put(Integer.valueOf(basket.getId()), basket);
        return basket;
    }

    @Override
    public IBasket get(int id) {
        return baskets.get(Integer.valueOf(id));
    }

    @Override
    public IBasket update(IBasket basket) {
        if (baskets.containsKey(basket.getId())) {
            baskets.remove(basket.getId());
            baskets.put(basket.getId(), basket);
            return basket;
        }
        return null;
    }

    @Override
    public boolean delete(IBasket basket) {
        if (baskets.containsKey(basket.getId())){
            baskets.remove(basket.getId());
            return true;
        }
        return false;
    }
    
}
