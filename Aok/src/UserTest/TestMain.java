package UserTest;

import Aok.*;
import DataModel.TestData;
import DataModel.TestDataModel;
import DataModel.ValueExampleObject;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException {
        /*TestData data1 = new TestData("name", "developer");
        data1.listAdd(new TestData("eric", "a"));
        data1.listAdd(new TestData("tina", "b"));*/
        // System.out.println(data1.getDataList());
        // System.out.println(tv.outPutHTML(data1));

        Aok aok = new Aok(8010);
        AokRouter testRouter = new AokRouter();
        AokRouter test2Router = new AokRouter();

        TestView tv = new TestView("helloworld.ftl");

        AokController testCtr = new TestController();
        AokController testStdCtr = new TestStdController();

        AokModel testModel = new TestDataModel();
        testModel.addView(tv);

        testRouter.setController(testCtr);
        test2Router.setController(testStdCtr);

        testStdCtr.setView(tv);
        testStdCtr.setModel(testModel);


        aok.addRouter("/", testRouter);
        aok.addRouter("/std", test2Router);
        aok.startServer();

    }
}
