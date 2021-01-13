package App.DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DB {

    public static void main(String[] args) {
        DB db = DB.getInstance();
        db.getCurriculumTable();
    }
    int curriculum = 0;

    public static DB db;
    Connection c = null;
    Statement stmt = null;
    Map<String, Student> studentMap = new HashMap<>();

    public static DB getInstance(){
        if(db == null){
            db = new DB();
        }
        return db;
    }

    private DB(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            stmt = c.createStatement();


            /* Student Table */
            if(!(c.getMetaData().getTables(null, null,  "STUDENT", null ).next()))
            {
                String sql = "CREATE TABLE STUDENT " +
                        "(USERNAME TEXT PRIMARY KEY     NOT NULL," +
                        "NAME           TEXT    NOT NULL, " +
                        "GENDER         TEXT, " +
                        "PASSWORD       TEXT NOT NULL," +
                        "CLASSNO       TEXT NOT NULL)";
                stmt.executeUpdate(sql);
            }
            /* Curriculum Table */
            //String subjectName;
            //    int week;
            //    int section;
            //    String classNo;
            if(!(c.getMetaData().getTables(null, null,  "CURRICULUM", null ).next()))
            {
                String sql = "CREATE TABLE CURRICULUM " +
                        "(SUBJECTNAME TEXT    NOT NULL," +
                        " WEEK           INT    NOT NULL, " +
                        " ID           INT  PRIMARY KEY  NOT NULL, " +
                        " SECTION         INT, " +
                        "CLASSNO       TEXT)";
                stmt.executeUpdate(sql);
            }
            /* Score */
            //    String subject;
            //    int mid;
            //    int fin;
            //    int total;
            //    int rank;
            //    String id;
            if(!(c.getMetaData().getTables(null, null,  "SCORE", null ).next()))
            {
                String sql = "CREATE TABLE SCORE " +
                        "(SUBJECT  TEXT    NOT NULL, " +
                        " MIN           INT    NOT NULL, " +
                        " FIN           INT   NOT NULL, " +
                        " TOTAL         INT NOT NULL, " +
                        " ID         TEXT NOT NULL, " +
                        "RANK       INT NOT NULL, " +
                        "CONSTRAINT SUBJECT_ID PRIMARY KEY (ID, SUBJECT))";
                stmt.executeUpdate(sql);
            }

            if(!(c.getMetaData().getTables(null, null,  "HOMEWORK", null ).next()))
            {
                String sql = "CREATE TABLE HOMEWORK " +
                        "(HOMEWORKNAME  TEXT    NOT NULL, " +
                        " CLASSNO        TEXT    NOT NULL, " +
                        "CONSTRAINT HOMEWORKNAME_CLASSNO PRIMARY KEY (HOMEWORKNAME, CLASSNO))";
                stmt.executeUpdate(sql);
            }
            stmt.executeUpdate("DELETE FROM STUDENT;");
            stmt.executeUpdate("DELETE FROM CURRICULUM;");
            stmt.executeUpdate("DELETE FROM SCORE;");
            stmt.executeUpdate("DELETE FROM HOMEWORK;");


            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }


    }


    /* Student Data */
    public void addStudent(String name, String gender, String username, String password,String classNo){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO STUDENT (USERNAME,NAME,GENDER,PASSWORD,CLASSNO) " +
                    "VALUES (\'"+username+"\',\'" + name +"\',\'" + gender +"\',\'" +password+"\',\'"+classNo+"\');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }

    public Student getStudent(String username){
        String userName=null;
        String name=null;
        String gender=null;
        String password=null;
        String classNo=null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);


            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM STUDENT WHERE USERNAME=\'"+username+"\';" );

            if(rs.next()) {
                userName = rs.getString("USERNAME");
                name = rs.getString("NAME");
                gender = rs.getString("GENDER");
                password = rs.getString("PASSWORD");
                classNo = rs.getString("CLASSNO");
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if (username!=null) {
            return new Student(name, gender, userName, password,classNo);
        }
        return new Student(null,null,null,null,null);
    }


    /* Curriculum */


    //"CREATE TABLE CURRICULUM " +
    //                        "(SUBJECTNAME TEXT    NOT NULL," +
    //                        " WEEK           INT    NOT NULL, " +
    //                        " ID           INT  PRIMARY KEY  NOT NULL, " +
    //                        " SECTION         INT, " +
    //                        "CLASSNO       TEXT)";
    public void addClass(String subject, int week, int section, String classNo){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO CURRICULUM (SUBJECTNAME,WEEK,SECTION,CLASSNO,ID) " +
                    "VALUES ('"+subject+"'," + week +"," + section +",'" +classNo+"',"+ curriculum +");";
            curriculum++;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }

    public Curriculum[][] getCurriculumTable(){

        Curriculum[][] table = new Curriculum[5][10];
        for(int i=0; i<5; i++){
            for(int j=0; j<10; j++){
                table[i][j] = new Curriculum("", i, j, "資訊三丙");
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<10; j++){
                String subjectname=null;
                int week=0;
                int section=0;
                String classno=null;
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
                    c.setAutoCommit(false);
                    stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT * FROM CURRICULUM WHERE WEEK ="+i+" AND SECTION="+j+";" );
                    if(rs.next()) {
                        subjectname = rs.getString("SUBJECTNAME");
                        week = rs.getInt("WEEK");
                        section = rs.getInt("SECTION");
                        classno = rs.getString("CLASSNO");
                    }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.exit(0);
                }
                if (subjectname!=null)
                table[i][j] = new Curriculum(subjectname, week, section, classno);
            }
        }
        return table;
    }

    /* ScoreTable */
    // String sql = "CREATE TABLE SCORE " +
    //                        "(SUBJECT  TEXT    NOT NULL, " +
    //                        " MIN           INT    NOT NULL, " +
    //                        " FIN           INT   NOT NULL, " +
    //                        " TOTAL         INT NOT NULL, " +
    //                        " ID         TEXT NOT NULL, " +
    //                        "RANK       INT NOT NULL, " +
    //                        "CONSTRAINT SUBJECT_ID PRIMARY KEY (ID, SUBJECT))";


    public void addSubjectScore(String subject, String id, int mid, int fin, int total, int rank){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO SCORE (SUBJECT,ID,MIN,FIN,TOTAL,RANK) " +
                    "VALUES (\'"+subject+"\',\'" + id +"\'," + mid +"," +fin+","+total+","+rank+");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public List<Score> getScoreList(String id){
        List<Score> score = new ArrayList<>();
        String subject=null;
        String nid=null;
        int mid=0;
        int fin=0;
        int total=0;
        int rank=0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM SCORE WHERE ID=\'"+id+"\';" );
            while(rs.next()) {
                subject = rs.getString("SUBJECT");
                nid = rs.getString("ID");
                mid = rs.getInt("MIN");
                fin = rs.getInt("FIN");
                total = rs.getInt("TOTAL");
                rank = rs.getInt("RANK");
                score.add(new Score(subject, mid, fin, total, id, rank));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ":" + e.getMessage() );
            System.exit(0);
        }
        //String subject, int mid, int fin, int total, String id, int rank)

        return score;
    }

    /* HomeWork */
    Map<String, List<HomeWork>> homeWorkMap = new HashMap<>();


    //String sql = "CREATE TABLE HOMEWORK " +
    //                        "(HOMEWORKNAME  TEXT    NOT NULL, " +
    //                        " CLASSNO           TEXT    NOT NULL, " +
    //                        "CONSTRAINT HOMEWORKNAME_CLASSNO PRIMARY KEY (HOMEWORKNAME, CLASSNO))";
    public void addHomeWork(String classNo, String homeWorkName){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO HOMEWORK (CLASSNO,HOMEWORKNAME) " +
                    "VALUES (\'"+classNo+"\',\'" + homeWorkName +"\');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void removeHomeWork(String classNo, HomeWork hObj){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate("DELETE FROM HOMEWORK WHERE CLASSNO = \'"+classNo+"\' AND HOMEWORKNAME = \'"+hObj.getHomeWorkName()+"\';");
            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public List<HomeWork> getHomeWork(String classNo){
        List<HomeWork> homework = new ArrayList<>();
        String nclassNo=null;
        String homeWorkName=null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM HOMEWORK WHERE CLASSNO='"+classNo+"';" );
            while(rs.next()) {
                nclassNo = rs.getString("CLASSNO");
                homeWorkName = rs.getString("HOMEWORKNAME");
                homework.add(new HomeWork(homeWorkName,nclassNo));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ":" + e.getMessage() );
            System.exit(0);
        }
        //String subject, int mid, int fin, int total, String id, int rank)

        return homework;
    }

}
