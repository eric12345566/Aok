package UserTest;

import Aok.AokController;
import Aok.HttpData;

public class TestStdController extends AokController {
    @Override
    public HttpData Get(HttpData request, HttpData response) {
        response.body = this.view.outPutHTML(this.model.getData());
        response.status = 200;
        response.header.set("Content-Type", "text/html; charset=utf-8");
        return response;
    }
}
