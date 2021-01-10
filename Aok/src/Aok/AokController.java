package Aok;

import com.sun.net.httpserver.HttpExchange;

public class AokController {
  AokView view = null;
  AokModel model = null;
  
  public String Get(HttpExchange exchange) {
    return "404";
  }
  
  public String Post(HttpExchange exchange) {
    return "404";
  }
  
  public String Delete(HttpExchange exchange) {
    return "404";
  }
  
  public String Put(HttpExchange exchange) {
    return "404";
  }
  
  public void setView(AokView v) {
    this.view = v;
  }
  
  public void setModel(AokModel m) {
    this.model = m;
  }
}
