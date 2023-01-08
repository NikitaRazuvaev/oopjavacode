package Semenar2.Model;

import java.util.Collection;

public interface IUserRepository {
    IUser create(IUser user);
    IUser get(int id);
    IUser update(IUser user);
    boolean delete(IUser user);
    
    Collection<IUser> getAll();
}
