package Semenar2.Model.Service;

import Semenar2.Model.User;
import Semenar2.Model.Interface.IUser;
import Semenar2.Model.InterfaceRepository.IUserRepository;
import Semenar2.Model.InterfaceService.IUserService;

public class UserService implements IUserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public IUser registre(String userName){
        if (getByName(userName) == null) {
            IUser newUser = new User(0, userName);
            newUser = userRepository.create(newUser);
            return newUser;
        }
        return null;
    }

    private IUser getByName(String name) {
        for (IUser user : userRepository.getAll()) {
            if (user.getName() == name) {
                return user;
            }
        }
        return null;
    }
}
