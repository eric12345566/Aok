package UserTest;

import Aok.AokView;

public class TestView extends AokView {
    public TestView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML(Object obj) {
        input.put("title", "Vogella example");
        input.put("exampleObject", obj);
        return getTemplate();
    }
}