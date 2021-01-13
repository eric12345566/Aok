package App.DB;

import Aok.AokData;

public class HomeWork extends AokData {
    String homeWorkName;
    String classNo;

    public HomeWork(String homeWorkName, String classNo) {
        this.homeWorkName = homeWorkName;
        this.classNo = classNo;
    }

    public String getHomeWorkName() {
        return homeWorkName;
    }

    public String getClassNo() {
        return classNo;
    }
}
