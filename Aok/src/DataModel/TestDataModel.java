package DataModel;

import Aok.AokData;
import Aok.AokModel;

public class TestDataModel extends AokModel {
    @Override
    public AokData generateAokData() {
        TestData data1 = new TestData("name", "developer");
        data1.listAdd(new TestData("eric", "a"));
        data1.listAdd(new TestData("tina", "b"));
        return data1;
    }
}
