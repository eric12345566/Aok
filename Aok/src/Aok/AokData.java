package Aok;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;

/**
 * 開發者可以繼承 AokData，使用一些工具方法，以及Encode方法
 */
public class AokData {
    /**
     * 開發者可自己定義 JsonEncode 要怎麼處理，可以使用 org.json.simple.JSONObject 來處理
     * @return 已經 Encode 成 json 的資料
     */
    public String jsonEncode(){
        return null;
    }

    /**
     * 可以將 map 轉乘 get qeury 或 post body 的標準格式
     * @param map http post 的 map 資料
     * @return 轉成 http post body 標準格式
     */
    public String mapToPostString(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
        String postString = "";

        while(itr.hasNext()){
            Map.Entry<String, String> entry = itr.next();
            postString = postString + entry.getKey() + "=" + entry.getValue();

            if(itr.hasNext()){
                postString += "&";
            }
        }

        return postString;
    }

    /**
     * 開發者可自己定義哪些資料要輸出 Post Data
     * 可以使用 mapToPostString(Map<String, String> map) 來將 map 轉成 post data
     * @return 轉成 http post body 標準格式
     */
    public String StringEncode(){
        return null;
    }
}
