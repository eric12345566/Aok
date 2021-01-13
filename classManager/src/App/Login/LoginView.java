package App.Login;

import Aok.AokView;

public class LoginView extends AokView {

    public LoginView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML() {
        return getTemplate();
    }
}
