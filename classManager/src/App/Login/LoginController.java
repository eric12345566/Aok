package App.Login;

import Aok.AokController;
import Aok.AokModel;
import Aok.HttpData;
import App.DB.Student;

public class LoginController extends AokController {
    protected LoginModel model;
    @Override
    public HttpData Get(HttpData request, HttpData response) {
        response.body = this.getResponseBody();
        return response;
    }

    @Override
    public HttpData Post(HttpData request, HttpData response) {
        String username = request.query.get("username");
        String password = request.query.get("password");
        if(this.model.loginStudent(username, password)){
            response.body = "success";
            redirector(response, "/home");
        }else{
            System.out.println("hello");
            response.body = "fail";
            redirector(response, "/login");
        }
        System.out.println("Username:" + username + "password: "+password);
        return response;
    }

    @Override
    public void setModel(AokModel m) {
        this.model = (LoginModel) m;
    }
}
