package App.Score;

import Aok.AokView;
import App.DB.Score;

import java.util.List;

public class ScoreView extends AokView {
    public ScoreView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML() {
        input.put("scores", dataObj);
        return getTemplate();
    }
}
