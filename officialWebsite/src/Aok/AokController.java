package Aok;

public abstract class AokController {
  protected AokView view = null;

  public AokController(){}
  
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
  
  public abstract void setModel(AokModel m);
  
  public String getResponseBody() {
    return this.view.outPutHTML();
  }

  public void redirector(HttpData httpData, String path){
    httpData.header.set("Location", path);
    httpData.status = 301;
  }

}
