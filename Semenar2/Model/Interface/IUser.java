package Semenar2.Model.Interface;

import org.w3c.dom.ranges.RangeException;

import Semenar2.Model.User;
import Semenar2.Model.Repository.UserRepository;

public interface IUser {
    int getId();
    String getName();
    default IUser create(UserRepository userRepository) {
        if (getId() == 0){
            int newId = userRepository.calculetNextKey(userRepository.users.keySet()) ;
            IUser newUser = new User(newId, this);
            userRepository.users.put(Integer.valueOf(newId), newUser);
            return newUser;
        }
    
        if (userRepository.users.containsKey(getId())){
            throw new RangeException((short) 1, String.format("user with id %d is present in repository", getId()));
        }
        userRepository.users.put(Integer.valueOf(getId()), this);
        return this; 
    }
    
}
