package Semenar2.Controler;

import Semenar2.Views.*;

public interface IUserControler {
    /**
     * @param request
     * @return
     * @throws Exception
     */
    UserView registre(UserRegisterRequest request) throws Exception;
}
