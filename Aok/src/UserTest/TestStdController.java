package UserTest;

import Aok.AokController;
import Aok.ContentType;
import Aok.HttpData;

public class TestStdController extends AokController {
    @Override
    public HttpData Get(HttpData request, HttpData response) {
        this.model.sendDataToView();
        response.body = this.getResponseBody();
        response.status = 200;
        response.type = ContentType.html;
        return response;
    }

    @Override
    public HttpData Post(HttpData request, HttpData response) {
        System.out.println("Request body: " + request.body);
        return super.Post(request, response);
    }
}
