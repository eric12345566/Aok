package App.DB;

import Aok.AokData;

public class Curriculum extends AokData {
    String subjectName;
    int week;
    int section;
    String classNo;

    public Curriculum(String subjectName, int week, int section, String classNo){
        this.subjectName = subjectName;
        this.week = week;
        this.section = section;
        this.classNo = classNo;
    }

    public String getSubjectName(){
        return this.subjectName;
    }
}
