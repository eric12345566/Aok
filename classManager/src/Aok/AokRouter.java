package Aok;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AokRouter implements HttpHandler {
  AokController ctr = new AokController();
  HttpData request = new HttpData();
  HttpData response = new HttpData();
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    // TODO Auto-generated method stub
    request.header = exchange.getRequestHeaders();
    response.header = exchange.getResponseHeaders();

    if("GET".equals(exchange.getRequestMethod())) {
      if(exchange.getRequestURI().getQuery() != null)
        request.query = request.queryToMap(exchange.getRequestURI().getQuery());
      response = ctr.Get(request, response);
    }
    
    else if("POST".equals(exchange.getRequestMethod())) {
      request.body = is2string(exchange.getRequestBody());
      request.query = request.queryToMap(is2string(exchange.getRequestBody()));
      response = ctr.Post(request, response);
    }
      
    else if("DELETE".equals(exchange.getRequestMethod())) { 
      response = ctr.Delete(request, response);
    }
      
    else if("PUT".equals(exchange.getRequestMethod())) { 
      response = ctr.Put(request, response);
    }
    
    setContentType();
    exchange.sendResponseHeaders(response.status, response.body.getBytes(StandardCharsets.UTF_8).length);

    OutputStream outputStream = exchange.getResponseBody();
    outputStream.write(response.body.getBytes(StandardCharsets.UTF_8));
    outputStream.flush();
    outputStream.close();
    
  }

  public void setController(AokController ctr){
    this.ctr = ctr;
  }
  
  private String is2string(InputStream is) throws IOException {
    final int bufferSize = 1024;
    final char[] buffer = new char[bufferSize];
    final StringBuilder out = new StringBuilder();
    Reader in = new InputStreamReader(is, "UTF-8");
    for (; ; ) {
        int rsz = in.read(buffer, 0, buffer.length);
        if (rsz < 0)
            break;
        out.append(buffer, 0, rsz);
    }
    return out.toString();
  }
  
  public void setContentType() {
    if(this.response.type == ContentType.json)
      response.header.set("Content-Type", "application/json; charset=utf-8");
    else if(this.response.type == ContentType.html)
      response.header.set("Content-Type", "text/html; charset=utf-8");
    else if(this.response.type == ContentType.plain)
      response.header.set("Content-Type", "text/plain; charset=utf-8");
    else if(this.response.type == ContentType.jpeg)
      response.header.set("Content-Type", "image/jpeg; charset=utf-8");
    else if(this.response.type == ContentType.png )
      response.header.set("Content-Type", "image/png; charset=utf-8");
    else if(this.response.type == ContentType.pdf)
      response.header.set("Content-Type", "application/pdf; charset=utf-8");
  }
  
  
}
