package Aok;

public class AokController {
  AokView view = null;
  AokModel model = null;
  HttpData response = new HttpData();
  
  public HttpData Get(HttpData request) {
    response.body = view.outPutHTML(model);
    return response;
  }
  
  public HttpData Post(HttpData request) {
    response.body = view.outPutHTML(model);
    return response;
  }
  
  public HttpData Delete(HttpData request) {
    response.body = view.outPutHTML(model);
    return response;
  }
  
  public HttpData Put(HttpData request) {
    response.body = view.outPutHTML(model);
    return response;
  }
  
  public void setView(AokView v) {
    this.view = v;
  }
  
  public void setModel(AokModel m) {
    this.model = m;
  }

}
