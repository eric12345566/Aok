package App.Data;

import Aok.AokData;
import App.DB.Curriculum;

import java.util.ArrayList;
import java.util.List;

public class CurriculumViewData extends AokData {
    public List<Curriculum> week1 = new ArrayList<>();
    public List<Curriculum> week2 = new ArrayList<>();
    public List<Curriculum> week3 = new ArrayList<>();
    public List<Curriculum> week4 = new ArrayList<>();
    public List<Curriculum> week5 = new ArrayList<>();

    public CurriculumViewData(Curriculum[][] table){
        // week1
        for(int i=0;i<10; i++){
            week1.add(table[0][i]);
        }

        // week2
        for(int i=0;i<10; i++){
            week2.add(table[1][i]);
        }

        // week3
        for(int i=0;i<10; i++){
            week3.add(table[2][i]);
        }

        // week4
        for(int i=0;i<10; i++){
            week4.add(table[3][i]);
        }

        // week5
        for(int i=0;i<10; i++){
            week5.add(table[4][i]);
        }
    }

    public List<Curriculum> getWeek1() {
        return week1;
    }

    public List<Curriculum> getWeek2() {
        return week2;
    }

    public List<Curriculum> getWeek3() {
        return week3;
    }

    public List<Curriculum> getWeek4() {
        return week4;
    }

    public List<Curriculum> getWeek5() {
        return week5;
    }
}
