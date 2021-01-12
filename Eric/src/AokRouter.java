import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public abstract class AokRouter {
  private AokController ctr;
    AokRouter(AokController ctr){
        this.ctr = ctr;
    }

    public void setController(AokController ctr){
        this.ctr=ctr;
    }


    public void handle(HttpExchange httpExchange) throws IOException {
        String htmlResponse = "";
        if("GET".equals(httpExchange.getRequestMethod())) {
            htmlResponse=ctr.get();
        }else if("POST".equals(httpExchange.getRequestMethod())) {//他忘記加上
            htmlResponse=ctr.post();
        } else if("PUT".equals(httpExchange.getRequestMethod())) {
            htmlResponse=ctr.put();
        }else if("DELETE".equals(httpExchange.getRequestMethod())) {
            htmlResponse=ctr.delete();
        }
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
