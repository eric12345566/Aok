package App.Homework;

import Aok.AokController;
import Aok.AokModel;
import Aok.HttpData;

public class HomeWorkController extends AokController {
    HomeWorkModel model;

    @Override
    public HttpData Get(HttpData request, HttpData response) {
        this.model.sendDataToView();
        response.body = this.getResponseBody();
        response.status = 200;
        return response;
    }

    @Override
    public HttpData Post(HttpData request, HttpData response) {
        this.model.checkedHomework(request.query);
        response.body = "success";
        redirector(response, "/homework");
        return response;
    }

    @Override
    public void setModel(AokModel m) {
        this.model = (HomeWorkModel) m;
    }
}
