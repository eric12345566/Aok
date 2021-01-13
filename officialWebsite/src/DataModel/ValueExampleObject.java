package DataModel;

import java.util.ArrayList;
import java.util.List;

public class ValueExampleObject {
    private String name;
    private String developer;
    private List<ValueExampleObject> dataList = new ArrayList<ValueExampleObject>();

    public ValueExampleObject(String name, String developer) {
        this.name = name;
        this.developer = developer;
    }

    public void listAdd(ValueExampleObject obj){
        dataList.add(obj);
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public List<ValueExampleObject> getDataList() {return dataList;};
}
