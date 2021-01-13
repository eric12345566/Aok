package App.DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {
    public static DB db;
    Map<String, Student> studentMap = new HashMap<>();

    public static DB getInstance(){
        if(db == null){
            db = new DB();
        }
        return db;
    }

    private DB(){}


    /* Student Data */
    public void addStudent(String name, String gender, String username, String password, String classNo){
        studentMap.put(username, new Student(name, gender, username, password, classNo));
    }

    public Student getStudent(String username){
        return studentMap.get(username);
    }


    /* Curriculum */
    Curriculum[][] table = new Curriculum[5][10];

    public void initCourseTable(){
        for(int i=0; i<5; i++){
            for(int j=0; j<10; j++){
                table[i][j] = new Curriculum("", i, j, "資訊三丙");
            }
        }
    }

    public void addClass(String subject, int week, int section, String classNo){
        table[week-1][section-1] = new Curriculum(subject, week, section, classNo);
    }

    public Curriculum[][] getCurriculumTable(){
        return table;
    }

    /* ScoreTable */
    Map<String, List<Score>> scoreMap = new HashMap<>();

    public void addSubjectScore(String subject, String id, int mid, int fin, int total, int rank){
        List<Score> list;
        if(scoreMap.containsKey(id)){
            list = scoreMap.get(id);
        }else{
            list = new ArrayList<Score>();
            scoreMap.put(id, list);
        }
        list.add(new Score(subject, mid, fin, total, id, rank));
    }

    public List<Score> getScoreList(String id){
        return scoreMap.get(id);
    }

    /* HomeWork */
    Map<String, List<HomeWork>> homeWorkMap = new HashMap<>();

    public void addHomeWork(String classNo, String homeWorkName){
        List<HomeWork> list;
        if(homeWorkMap.containsKey(classNo)){
            list = homeWorkMap.get(classNo);
        }else{
            list = new ArrayList<HomeWork>();
            homeWorkMap.put(classNo, list);
        }

        list.add(new HomeWork(homeWorkName, classNo));
    }

    public List<HomeWork> getHomeWork(String classNo){
        return homeWorkMap.get(classNo);
    }

}
