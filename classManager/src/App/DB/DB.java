package App.DB;

import java.util.HashMap;
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
    public void addStudent(String name, String gender, String username, String password){
        studentMap.put(username, new Student(name, gender, username, password));
    }

    public Student getStudent(String username){
        return studentMap.get(username);
    }

}
