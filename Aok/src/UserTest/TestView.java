package UserTest;

import Aok.AokData;
import Aok.AokView;

import java.util.Observable;

public class TestView extends AokView {
    public TestView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML() {
        input.put("title", "Vogella example");
        input.put("exampleObject", this.dataObj);
        return getTemplate();
    }
}
