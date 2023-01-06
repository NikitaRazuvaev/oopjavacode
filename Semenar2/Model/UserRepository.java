package Semenar2.Model;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ranges.RangeException;

import java.util.Collections;

public class UserRepository implements IUserRepository {

    private Map<Integer, IUser> users;
    
    public UserRepository(){
        users = new HashMap<>();
    }
    
    @Override
    public IUser create(IUser user) {
        if (user.getId() == 0){
            int newId = Collections.max(users.keySet()) +1 ;
            IUser newUser = new User(newId, user);
            users.put(Integer.valueOf(newId), newUser);
            return newUser;
        }

        if (users.containsKey(user.getId())){
            throw new RangeException((short) 1, String.format("user with id %d is present in repository", user.getId()));
        }
        users.put(Integer.valueOf(user.getId()), user);
        return user; 
    }


    @Override
    public IUser get(int id) {
        return users.get(Integer.valueOf(id));
    }

    @Override
    public IUser update(IUser user) {
        if(users.containsKey(user.getId())){
            users.remove(user.getId());
            users.put(user.getId(), user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(IUser user) {
        if(users.containsKey(user.getId())){
            users.remove(user.getId());
            return true;
        }
        return false;
    }

    @Override
    public IUser getByName(String name) {
        for (IUser user : users.values()) {
            if (user.getName()==name){
                return user;
            }
        }
        return null;
    }

    
}
