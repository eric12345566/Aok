package App.Homework;

import Aok.AokModel;
import App.DB.DB;
import App.DB.HomeWork;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeWorkModel extends AokModel {
    DB db;

    public HomeWorkModel(){
        this.db = DB.getInstance();
        this.db.addHomeWork("資訊三丙", "物件導向專題");
        this.db.addHomeWork("資訊三丙", "Design Pattern");
        this.db.addHomeWork("資訊三丙", "程式設計");
        this.db.addHomeWork("資訊三丙", "iOS");
    }

    public boolean checkedHomework(Map<String, String> map){
        Iterator<Map.Entry<String, String>> reqItr = map.entrySet().iterator();
        List<HomeWork> list = this.db.getHomeWork("資訊三丙");
        Iterator<HomeWork> itr = list.iterator();
        HomeWork obj;

        while(reqItr.hasNext()){
            Map.Entry<String, String> entry = reqItr.next();
            while(itr.hasNext()){
                obj = itr.next();
                if(obj.getHomeWorkName().equals(entry.getValue())){
                    this.db.removeHomeWork("資訊三丙", obj);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Object generateAokData() {
        return this.db.getHomeWork("資訊三丙");
    }
}
