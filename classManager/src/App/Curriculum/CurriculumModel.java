package App.Curriculum;

import Aok.AokData;
import Aok.AokModel;
import App.DB.Curriculum;
import App.DB.DB;
import App.Data.CurriculumViewData;

public class CurriculumModel extends AokModel {
    DB db;

    public CurriculumModel(){
        this.db = DB.getInstance();
        db.addClass("物件導向軟體工程", 1, 1, "資訊三丙");
        db.addClass("物件導向軟體工程", 1, 2, "資訊三丙");
        db.addClass("英文", 3, 3, "資訊三丙");
        db.addClass("英文", 3, 4, "資訊三丙");
    }

    @Override
    public Object generateAokData() {
        return null;
    }
}
