package App.Homework;

import Aok.AokView;

public class HomeWorkView extends AokView {
    public HomeWorkView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML() {
        input.put("dataList", this.dataObj);
        return getTemplate();
    }
}
