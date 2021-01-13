package App.Curriculum;

import Aok.AokController;
import Aok.AokModel;
import Aok.HttpData;
import App.Data.CurriculumViewData;

public class CurriculumController extends AokController {
    CurriculumModel model;

    @Override
    public HttpData Get(HttpData request, HttpData response) {
        this.model.sendDataToView();
        response.body = this.getResponseBody();
        return response;
    }

    @Override
    public HttpData Post(HttpData request, HttpData response) {
        return super.Post(request, response);
    }

    @Override
    public void setModel(AokModel m) {
        this.model = (CurriculumModel) m;
    }
}
