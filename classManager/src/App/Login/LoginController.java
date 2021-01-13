package App.Login;

import Aok.AokController;
import Aok.HttpData;
import App.DB.Student;

public class LoginController extends AokController {
    @Override
    public HttpData Get(HttpData request, HttpData response) {

        return super.Get(request, response);
    }

    @Override
    public HttpData Post(HttpData request, HttpData response) {
        String username = request.query.get("username");
        String password = request.query.get("password");
        return super.Post(request, response);
    }
}
