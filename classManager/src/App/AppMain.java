package App;
import Aok.*;
import App.Login.LoginController;
import App.Login.LoginModel;
import App.Login.LoginView;

import java.io.IOException;

public class AppMain {
    public static void main(String[] args) throws IOException {
        /* Main App */
        Aok aok = new Aok(8020);

        /* Login */
        AokController loginController = new LoginController();
        AokView loginView = new LoginView("login.html");
        AokModel loginModel = new LoginModel();
        AokRouter loginRouter = new AokRouter();

        loginController.setModel(loginModel);
        loginController.setView(loginView);
        loginModel.addView(loginView);
        loginRouter.setController(loginController);
        aok.addRouter("/login", loginRouter);

        /* Start App */
        aok.startServer();
    }
}
