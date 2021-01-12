package Aok;

import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.Headers;

public class HttpData {
  public String body = null;
  public Headers header;
  public int status = 404;
  public Map<String, String> query;
  public ContentType type = null;
  
  public Map<String, String> queryToMap(String query) {
    Map<String, String> result = new HashMap<>();
    for (String param : query.split("&")) {
        String[] entry = param.split("=");
        if (entry.length > 1) {
            result.put(entry[0], entry[1]);
        }else{
            result.put(entry[0], "");
        }
    }
    return result;
  }
  
  public void setStatus(int s) {
    this.status = s;
  }

}

