package Semenar2.Controler;


import Semenar2.Model.IUser;
import Semenar2.Model.IUserRepository;
import Semenar2.Model.User;
import Semenar2.Views.UserRegisterRequest;
import Semenar2.Views.UserView;

public class UserControler extends ControlersBase implements IUserControler {

    private IUserRepository userRepository;

    public UserControler(IUserRepository repository){
        this.userRepository = repository;
    }

    @Override
    public UserView registre(UserRegisterRequest request) throws Exception {
        if (userRepository.getByName(request.name) == null) {
            IUser newUser = new User(0, request.name);
            newUser = userRepository.create(newUser);
            return new UserView(newUser);
        }
        throw new Exception(String.format("user with name %s exist allready",request.name));
    }    
}
