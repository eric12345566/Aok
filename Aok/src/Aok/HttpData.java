package Aok;

import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.Headers;

public class HttpData {
  String body = null;
  Headers header;
  int status = 404;
  Map<String, String> query;
  
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

