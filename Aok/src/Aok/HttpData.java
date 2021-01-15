package Aok;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.Headers;

/**
 * 儲存所有response和request得到的資料(ex.header、body)。
 */
public class HttpData {
  public String body = null;
  public Headers header;
  public int status = 404;
  public Map<String, String> query;
  public Map<String, List<String>> headerMap;
  public ContentType type = null;
    /**
     * 把接收到的 query 轉換成 map型態
     * @param query  接收到的 query
     * @return query的map型態
     */
  public Map<String, String> queryToMap(String query) {
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

    /**
     * 設定 status 的值
     * @param s 想設定的status
     */
  public void setStatus(int s) {
    this.status = s;
  }

}

