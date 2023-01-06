package Semenar2.Model;

public interface IUserRepository {
    IUser create(IUser user);
    IUser get(int id);
    IUser update(IUser user);
    boolean delete(IUser user);
    
    IUser getByName(String name);
}
