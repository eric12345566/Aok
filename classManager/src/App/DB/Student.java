package App.DB;

import Aok.AokData;

public class Student extends AokData {
    public String name;
    public String gender;
    public String id;
    public String classNo;
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(String name, String gender, String id, String password, String classNo){
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.password = password;
        this.classNo = classNo;
    }
}
