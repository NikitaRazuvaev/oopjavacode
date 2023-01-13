package Semenar2.Model.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Semenar2.Model.Interface.IUser;
import Semenar2.Model.InterfaceRepository.IUserRepository;


public class UserRepository extends AbstractRepository implements IUserRepository {

    public Map<Integer, IUser> users;
    
    public UserRepository(){
        users = new HashMap<>();
    }
    
    public Collection<IUser> getAll()  {
        return users.values();
    }
    
    @Override
    public IUser create(IUser user) {
        return user.create(this);
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
    
}
