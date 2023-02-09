package Semenar2.Model.InterfaceRepository;

import java.util.Collection;

import Semenar2.Model.Interface.IUser;

public interface IUserRepository {
    IUser create(IUser user);
    IUser get(int id);
    IUser update(IUser user);
    boolean delete(IUser user);
    
    Collection<IUser> getAll(); // Заменить на функцию search с возможностю задания предикатта 
}
