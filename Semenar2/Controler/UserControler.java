package Semenar2.Controler;


import Semenar2.Controler.Interface.IUserControler;
import Semenar2.Model.Interface.IUser;
import Semenar2.Model.InterfaceService.IUserService;
import Semenar2.Views.UserView;
import Semenar2.Views.Request.UserRegisterRequest;

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
