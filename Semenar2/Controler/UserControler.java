package Semenar2.Controler;


import Semenar2.Model.IUser;
import Semenar2.Model.IUserService;
import Semenar2.Views.UserRegisterRequest;
import Semenar2.Views.UserView;

public class UserControler extends ControlersBase implements IUserControler {

    private IUserService userService;

    public UserControler(IUserService service){
        this.userService = service;
    }

    @Override
    public UserView registre(UserRegisterRequest request){
        IUser user = userService.registre(request.name); 
        if (user != null) {
            return new UserView(user);
        }
        return null;
    }    
}
