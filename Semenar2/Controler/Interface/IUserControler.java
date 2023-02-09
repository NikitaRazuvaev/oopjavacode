package Semenar2.Controler.Interface;

import Semenar2.Views.*;
import Semenar2.Views.Request.UserRegisterRequest;

public interface IUserControler {
    /**
     * @param request
     * @return
     * @throws Exception
     */
    UserView registre(UserRegisterRequest request) throws Exception; 
}
