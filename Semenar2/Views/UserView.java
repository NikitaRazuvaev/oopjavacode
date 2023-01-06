package Semenar2.Views;

import Semenar2.Model.IUser;

public class UserView {
    public int id;
    public String name;

    public UserView(IUser user){
        this.id = user.getId();
        this.name = user.getName();
    };
}


