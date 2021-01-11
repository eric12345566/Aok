package UserTest;

import Aok.*;
import DataModel.TestData;
import DataModel.ValueExampleObject;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException {

        /*TestView tv = new TestView("helloworld.ftl");
        TestData data1 = new TestData("name", "developer");
        data1.listAdd(new TestData("eric", "a"));
        data1.listAdd(new TestData("tina", "b"));
        // System.out.println(data1.getDataList());
        System.out.println(tv.outPutHTML(data1));*/

        Aok aok = new Aok(8010);
        AokRouter testRouter = new AokRouter();
        AokController testCtr = new TestController();
        testRouter.setController(testCtr);
        aok.addRouter("/", testRouter);
        aok.startServer();

    }
}
