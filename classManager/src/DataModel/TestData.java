package DataModel;

import Aok.AokData;

import java.util.ArrayList;
import java.util.List;

public class TestData extends AokData {
    private String name;
    private String developer;
    private List<TestData> dataList = new ArrayList<TestData>();

    public TestData(String name, String developer) {
        this.name = name;
        this.developer = developer;
    }

    public void listAdd(TestData obj){
        dataList.add(obj);
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public List<TestData> getDataList() {return dataList;};
}
