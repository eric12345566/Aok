package UserTest;

import Aok.Aok;
import DataModel.ValueExampleObject;

public class TestMain {
    public static void main(String[] args) {
        TestView tv = new TestView("helloworld.ftl");
        ValueExampleObject data1 = new ValueExampleObject("name", "developer");
        data1.listAdd(new ValueExampleObject("eric", "a"));
        data1.listAdd(new ValueExampleObject("tina", "b"));
        // System.out.println(data1.getDataList());
        System.out.println(tv.outPutHTML(data1));
    }
}
