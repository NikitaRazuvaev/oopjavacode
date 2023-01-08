package Semenar2.Model;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ranges.RangeException;

import java.util.ArrayList;
import java.util.Collection;



public class BasketRepository extends AbstractRepository implements IBasketRepository{

    private Map<Integer, IBasket> baskets;
    public BasketRepository(){
        baskets = new HashMap<>();
    }
    public Collection<IBasket> getAll()  {
        return baskets.values();
    }
    @Override
    public IBasket create(IBasket basket) {
        if (basket.getId() ==0 ){
            int newId = calculetNextKey(baskets.keySet());
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


    @Override
    public IBasket getOrCreateForUser(IUser user) {
        for (IBasket basket : baskets.values()) {
            if (basket.getUser().getId() == user.getId() && ! basket.isPaid()) {
                return basket;
            }
        }
        
        IBasket basket = new Basket(0, user, new ArrayList<IProduct>(), false, "");
        basket = create(basket);
        return basket;
    }
}
