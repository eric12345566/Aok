package Aok;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AokRouter implements HttpHandler {
  AokController ctr = new AokController();
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    // TODO Auto-generated method stub
    String htmlResponse = "";
    if("GET".equals(exchange.getRequestMethod())) {
      htmlResponse = ctr.Get(exchange);
    }
    
    else if("POST".equals(exchange.getRequestMethod())) { 
      htmlResponse = ctr.Post(exchange);
    }
      
    else if("DELETE".equals(exchange.getRequestMethod())) { 
      htmlResponse = ctr.Delete(exchange);
    }
      
    else if("PUT".equals(exchange.getRequestMethod())) { 
      htmlResponse = ctr.Put(exchange);
    }
    
    exchange.sendResponseHeaders(setStatus(htmlResponse), htmlResponse.length());
    
    OutputStream outputStream = exchange.getResponseBody();
    outputStream.write(htmlResponse.getBytes());
    outputStream.flush();
    outputStream.close();
    
  }
  
  public int setStatus(String s) {
    if(s.equals("404"))
      return 404;
    else
      return 200;
  }
  
}
