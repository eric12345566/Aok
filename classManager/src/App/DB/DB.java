package App.DB;
import java.util.HashMap;
import java.util.Map;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DB {


    public static DB db;
    Map<String, Student> studentMap = new HashMap<>();
    Connection c = null;
    Statement stmt = null;
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
            System.out.println("Opened database successfully");
            stmt = c.createStatement();

            if(!(c.getMetaData().getTables(null, null,  "ClASS", null ).next()))
            {
                String sql = "CREATE TABLE CLASS " +
                        "(USERNAME TEXT PRIMARY KEY     NOT NULL," +
                        " NAME           TEXT    NOT NULL, " +
                        " GENDER         TEXT, " +
                        " PASSWORD       TEXT NOT NULL)";
                stmt.executeUpdate(sql);
                System.out.println("create");
            }


            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }


    }

    /* Student Data */
    public void addStudent(String name, String gender, String username, String password){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO CLASS (USERNAME,NAME,GENDER,PASSWORD) " +
                    "VALUES ("+username+"," + name +"," + gender +"," +password+");";
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
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:curriculum.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");


            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM CLASS WHERE USERNAME="+username+";" );

                if(rs.next()) {
                    userName = rs.getString("USERNAME");
                    name = rs.getString("NAME");
                    gender = rs.getString("GENDER");
                    password = rs.getString("PASSWORD");
                }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if (username!=null) {
            return new Student(name, gender, userName, password);
        }
        return new Student(null,null,null,null);
    }

}
