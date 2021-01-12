package UserTest;

import Aok.AokController;
import Aok.ContentType;
import Aok.HttpData;

public class TestStdController extends AokController {
    @Override
    public HttpData Get(HttpData request, HttpData response) {
        response.body = this.getResponseBody();
        response.status = 200;
        response.type = ContentType.html;
        return response;
    }
}
