package App;

import Aok.*;
import App.Home.HomeController;

import java.io.IOException;

public class AppMain {
    public static void main(String[] args) throws IOException {
        // Aok Server
        Aok aok = new Aok(8030);

        // Home
        AokController homeController = new HomeController();
        AokRouter homeRouter = new AokRouter();

        homeRouter.setController(homeController);

        aok.addRouter("/", homeRouter);

        // start server
        aok.startServer();
    }
}
