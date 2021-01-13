package App.Login;

import Aok.AokData;
import Aok.AokModel;
import App.DB.*;


public class LoginModel extends AokModel {
    DB db;
    public LoginModel(){
        super();
        this.db = DB.getInstance();

        // fake data
        db.addStudent("施冠彰", "m", "eric", "1234");
        db.addStudent("楊依辰", "f","tina", "1234");
        db.addStudent("戎宥杰", "m","rj", "1234");
        db.addStudent("黃子騰", "m","tw", "1234");
    }

    public boolean loginStudent(String username, String password){
        if(db.getStudent(username).password.equals(password)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public AokData generateAokData() {
        return null;
    }
}
