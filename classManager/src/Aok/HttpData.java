package Aok;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.Headers;

public class HttpData {
  public String body = null;
  public Headers header;
  public int status = 404;
  public Map<String, String> query;
  public Map<String, List<String>> headerMap;
  public ContentType type = null;
  
  public Map<String, String> queryToMap(String query) {
      System.out.println("queryToMap:" + query);
    Map<String, String> result = new HashMap<>();
    for (String param : query.split("&")) {
        String[] entry = param.split("=");
        if (entry.length > 1) {
            String prevURL = "";
            String decodeURL = entry[1];
            try {
                while(!prevURL.equals(decodeURL)) {
                    prevURL = decodeURL;
                    decodeURL = URLDecoder.decode( decodeURL, "UTF-8" );
                }
            } catch (UnsupportedEncodingException e) {
                System.out.println("HTTPDataUrlDecodeError: " + e.getMessage());
            }
            entry[1] = decodeURL;
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

