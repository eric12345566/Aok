package App.Score;

import Aok.AokData;
import Aok.AokModel;
import App.DB.DB;
import App.DB.Score;
import App.DB.Student;
import App.Data.ScoreViewData;

import java.util.List;

public class ScoreModel extends AokModel {
    DB db;

    public ScoreModel(){
        this.db = DB.getInstance();
        this.db.addSubjectScore("物件導向程式設計", "eric",100, 100, 100, 100);
        this.db.addSubjectScore("程式設計", "eric",100, 100, 100, 100);
        this.db.addSubjectScore("設計", "eric",100, 100, 100, 100);
        this.db.addSubjectScore("掰掰", "eric",100, 100, 100, 100);
    }

    public List<Score> getScoreList(String id){
        return this.db.getScoreList(id);
    }

    public Student getStudent(String id){
        return this.db.getStudent(id);
    }

    @Override
    public Object generateAokData() {
        ScoreViewData data = new ScoreViewData(this.getStudent("eric"), this.getScoreList("eric"));
        return data;
    }
}
