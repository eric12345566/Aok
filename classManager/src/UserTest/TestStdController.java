package UserTest;

import Aok.AokController;
import Aok.AokModel;
import Aok.ContentType;
import Aok.HttpData;
import UserTest.DataModel.TestDataModel;

import java.util.*;

public class TestStdController extends AokController {
    TestDataModel model;
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
        // System.out.println(request.header.entrySet());
        System.out.println(request.headerMap.get("Content-type").get(0));
        System.out.println(request.query.get("name"));
        response.body = "你好";
        return response;
    }

    @Override
    public void setModel(AokModel m) {
        this.model = (TestDataModel) m;
    }

    public Map<String, List<String>> setToMap(Set set) {
        Iterator<Map.Entry<String, List<String>>> itr = set.iterator();
        Map<String, List<String>> map = new HashMap<>();
        while(itr.hasNext()){
            Map.Entry<String, List<String>> entry = itr.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
}
