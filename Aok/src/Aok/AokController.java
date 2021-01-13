package Aok;

public class AokController {
  protected AokView view = null;
  protected AokModel model = null;

  public AokController(){}

  public AokController(AokModel model, AokView view){
    this.model = model;
    this.view = view;
  }
  
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
    return this.view.outPutHTML();
  }

}
