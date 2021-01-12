package Aok;

public class AokController {
  public AokView view = null;
  public AokModel model = null;
  
  public HttpData Get(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }
  
  public HttpData Post(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }
  
  public HttpData Delete(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }
  
  public HttpData Put(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }
  
  public void setView(AokView v) {
    this.view = v;
  }
  
  public void setModel(AokModel m) {
    this.model = m;
  }
  
  public String getResponseBody() {
    return this.view.outPutHTML(this.model.getData());
  }

}
