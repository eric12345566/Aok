package App.Homework;

import Aok.AokModel;
import App.DB.DB;

public class HomeWorkModel extends AokModel {
    DB db;

    public HomeWorkModel(){
        this.db = DB.getInstance();
        this.db.addHomeWork("資訊三丙", "物件導向專題");
        this.db.addHomeWork("資訊三丙", "Design Pattern");
    }

    @Override
    public Object generateAokData() {
        return this.db.getHomeWork("資訊三丙");
    }
}
