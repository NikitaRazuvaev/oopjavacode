package Semenar2.Views;


import Semenar2.Model.GeoPoint;
import Semenar2.Model.Interface.IAvtomat;

public class AvtomatView {
    public int id;
    public GeoPoint point;

    public  AvtomatView(IAvtomat sourse){
        this.id = sourse.getId();
        this.point = sourse.getPoint();
    }
}
