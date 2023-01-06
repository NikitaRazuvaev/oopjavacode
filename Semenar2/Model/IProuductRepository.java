package Semenar2.Model;

public interface IProuductRepository {
    IProduct create(IProduct product);
    IProduct get(int id);
    IProduct update(IProduct product);
    boolean delete(IProduct product);
}
