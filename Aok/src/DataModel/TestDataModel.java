package DataModel;

import Aok.AokData;
import Aok.AokModel;

public class TestDataModel implements AokModel {
    @Override
    public AokData getData() {
        TestData data1 = new TestData("name", "developer");
        data1.listAdd(new TestData("eric", "a"));
        data1.listAdd(new TestData("tina", "b"));
        return data1;
    }
}
