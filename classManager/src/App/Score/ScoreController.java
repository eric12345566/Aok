package App.Score;

import Aok.AokController;
import Aok.AokModel;
import Aok.HttpData;

public class ScoreController extends AokController {
    ScoreModel model;

    @Override
    public HttpData Get(HttpData request, HttpData response) {
        this.model.sendDataToView();
        response.body = this.getResponseBody();
        return response;
    }

    @Override
    public void setModel(AokModel m) {
        this.model = (ScoreModel) m;
    }
}
