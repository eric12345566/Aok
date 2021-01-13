package App.Data;

import Aok.AokData;
import App.DB.Score;
import App.DB.Student;

import java.util.List;

public class ScoreViewData extends AokData {
    Student student;
    List<Score> list;

    public ScoreViewData(Student student, List<Score> list) {
        this.student = student;
        this.list = list;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Score> getList() {
        return list;
    }

    public void setList(List<Score> list) {
        this.list = list;
    }
}
