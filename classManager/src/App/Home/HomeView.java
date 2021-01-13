package App.Home;

import Aok.AokView;

public class HomeView extends AokView {
    public HomeView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML() {
        return getTemplate();
    }
}
