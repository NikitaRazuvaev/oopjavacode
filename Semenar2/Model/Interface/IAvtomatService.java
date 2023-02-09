package Semenar2.Model.Interface;

import java.util.Collection;

public interface IAvtomatService {
    
    Collection<IAvtomat> getAvtomats();

    Collection<IProduct> getOrderedProducts(String code, int avtomatID); // Нарушает принцип разделения интерфейса Вынести в отдельный интерфейс для продуктов.

    IProduct getBestProduct(int avtomatID); // Нарушает принцип разделения интерфейса Вынести в отдельный интерфейс для продуктов.

}