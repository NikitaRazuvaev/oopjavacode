package Semenar2.Model;

public class User implements IUser{

    private int id;
    private String name;
    public User(int id, String name){
        this.id=id;
        this.name=name;
    }

    public User(int id, IUser user){
        this.id=id;
        this.name=user.getName();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
