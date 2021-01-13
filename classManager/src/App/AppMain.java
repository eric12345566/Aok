package App;
import Aok.*;
import App.Curriculum.CurriculumController;
import App.Curriculum.CurriculumModel;
import App.Curriculum.CurriculumView;
import App.Homework.HomeWorkController;
import App.Homework.HomeWorkModel;
import App.Homework.HomeWorkView;
import App.Login.LoginController;
import App.Login.LoginModel;
import App.Login.LoginView;
import App.Score.ScoreController;
import App.Score.ScoreModel;
import App.Score.ScoreView;

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

        /* Curriculum */
        AokController curriculumController = new CurriculumController();
        AokView curriculumView = new CurriculumView("coursetable.ftl");
        AokModel curriculumModel = new CurriculumModel();
        AokRouter curriculumRouter = new AokRouter();

        curriculumController.setModel(curriculumModel);
        curriculumController.setView(curriculumView);
        curriculumModel.addView(curriculumView);
        curriculumRouter.setController(curriculumController);
        aok.addRouter("/curriculum", curriculumRouter);

        /* Score */
        AokController scoreController = new ScoreController();
        AokView scoreView = new ScoreView("score.ftl");
        AokModel scoreModel = new ScoreModel();
        AokRouter scoreRouter = new AokRouter();

        scoreController.setModel(scoreModel);
        scoreController.setView(scoreView);
        scoreModel.addView(scoreView);
        scoreRouter.setController(scoreController);
        aok.addRouter("/score", scoreRouter);

        /* Homework */
        AokController homeWorkController = new HomeWorkController();
        AokView homeWorkView = new HomeWorkView("homework.ftl");
        AokModel homeWorkModel = new HomeWorkModel();
        AokRouter homeWorkRouter = new AokRouter();

        homeWorkController.setModel(homeWorkModel);
        homeWorkController.setView(homeWorkView);
        homeWorkModel.addView(homeWorkView);
        homeWorkRouter.setController(homeWorkController);
        aok.addRouter("/homework", homeWorkRouter);

        /* Start App */
        aok.startServer();
    }
}
