package UserTest;

import Aok.AokData;
import Aok.AokView;

public class TestView extends AokView {
    public TestView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML(AokData obj) {
        input.put("title", "Vogella example");
        input.put("exampleObject", obj);
        return getTemplate();
    }
}
