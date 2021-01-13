package App.Home;

import Aok.AokController;
import Aok.AokModel;
import Aok.HttpData;

public class HomeController extends AokController {
    @Override
    public HttpData Get(HttpData request, HttpData response) {
        response.body = getResponseBody();
        return response;
    }

    @Override
    public void setModel(AokModel m) {

    }
}
