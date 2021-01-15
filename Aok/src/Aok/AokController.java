package Aok;

/**
 * 主要負責處理 GET 、POST 、PUT 、DELETE ，這些 HttpMethod被 client 端呼叫時所需做的動作。
 */
public abstract class AokController {

  protected AokView view = null;

  /**
   * Aok建構子
   */
  public AokController(){}

  /**
   * 處理 Get 時須執行的動作
   * @param request 請求的關資料
   * @param response 回應的相關資料
   * @return 將自定好的response資料回傳
   */
  public HttpData Get(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }
  /**
   * 處理 Post 時須執行的動作
   * @param request 請求的關資料
   * @param response 回應的相關資料
   * @return 將自定好的response資料回傳
   */
  public HttpData Post(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }
  /**
   * 處理 Delete 時須執行的動作
   * @param request 請求的關資料
   * @param response 回應的相關資料
   * @return 將自定好的response資料回傳
   */
  public HttpData Delete(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }
  /**
   * 處理 Put 時須執行的動作
   * @param request 請求的關資料
   * @param response 回應的相關資料
   * @return 將自定好的response資料回傳
   */
  public HttpData Put(HttpData request, HttpData response) {
    response.body = "404";
    return response;
  }

  /**
   * 設定view的值
   * @param v 要設定的 AokView
   */
  public void setView(AokView v) {
    this.view = v;
  }
  /**
   * 設定model的值
   * @param m 要設定的 AokModel
   */
  public abstract void setModel(AokModel m);
  
  public String getResponseBody() {
    return this.view.outPutHTML();
  }

  /**
   * 將網頁重新導向
   * @param httpData 想設定的 httpData
   * @param path 想跳轉的路徑
   */
  public void redirector(HttpData httpData, String path){
    httpData.header.set("Location", path);
    httpData.status = 301;
  }

}
