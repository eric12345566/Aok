package Aok;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * 主要負責處理靜態檔案，檔案路徑預設在該project下層的資料夾下(AoK/src/Assets/檔案名稱)，
 * 像是html、css、jpg….等型態的檔案。
 */
public class AssetsRouter extends AokRouter implements HttpHandler{
	
	String fileName;
	HttpData request = new HttpData();
	HttpData response = new HttpData();

	/**
	 * 在 HttpHandler GET 到靜態檔案時做處理，並將資料response給Server
	 * @param exchange 包括所有請求資料
	 * @throws IOException 當發生錯誤時的拋出
	 */
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		request.header = exchange.getRequestHeaders();
	    response.header = exchange.getResponseHeaders();
		response.status = 200;
	    if("GET".equals(exchange.getRequestMethod())) {

	        if(exchange.getRequestURI().getQuery() != null)
	          request.query = request.queryToMap(exchange.getRequestURI().getQuery());
	        fileName = exchange.getRequestURI().getPath();
	    	if(fileName.startsWith("/")==true)
                fileName = fileName.substring(8);
	    	fileName = "./src/Assets/" + fileName;
	    }
	    OutputStream outputStream = exchange.getResponseBody();
	    
	    if(fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
            File file = new File(fileName);
            int numOfBytes = (int) file.length();
    	    exchange.sendResponseHeaders(response.status, numOfBytes);
    	    FileInputStream inFile = new FileInputStream(fileName);
            byte[] fileInBytes = new byte[numOfBytes];
            inFile.read(fileInBytes);
            outputStream.write(fileInBytes, 0, numOfBytes);
            System.out.println("ok");
            inFile.close();
            System.out.println("Sending data completely.");
        }
	    else if (fileName.endsWith(".html") ) {
	    	File file = new File(fileName);
        	InputStreamReader read = new InputStreamReader (new FileInputStream(file),"UTF-8");
        	BufferedReader br = new BufferedReader(read);
    		String str = null;
    		String sumStr = "";
    		response.type = ContentType.html;
    		setContentType();
    		
    		while ((str = br.readLine()) != null) {
    			sumStr = sumStr + process(str);
    		}
    		response.header.set("Content-Type", "text/html; charset=UTF-8");
    		exchange.sendResponseHeaders(response.status, sumStr.getBytes("UTF-8").length);
    		// System.out.println(sumStr);
			outputStream.write(sumStr.getBytes("UTF-8"));
    		br.close();
        }
	    else if (fileName.endsWith(".css") ) {
	    	File file = new File(fileName);
        	InputStreamReader read = new InputStreamReader (new FileInputStream(file),"UTF-8");
        	BufferedReader br = new BufferedReader(read);
    		String str = null;
    		String sumStr = "";
    		response.type = ContentType.html;
    		setContentType();
    		
    		while ((str = br.readLine()) != null) {
    			sumStr = sumStr + process(str);
    		}
    		response.header.set("Content-Type", "text/css; charset=UTF-8");
    		exchange.sendResponseHeaders(response.status, sumStr.getBytes("UTF-8").length);
    		// System.out.println(sumStr);
			outputStream.write(sumStr.getBytes("UTF-8"));
    		br.close();
        }
	    else if (fileName.endsWith(".js") ) {
	    	File file = new File(fileName);
        	InputStreamReader read = new InputStreamReader (new FileInputStream(file),"UTF-8");
        	BufferedReader br = new BufferedReader(read);
    		String str = null;
    		String sumStr = "";
    		response.type = ContentType.html;
    		setContentType();
    		
    		while ((str = br.readLine()) != null) {
    			sumStr = sumStr + str;
    		}
    		response.header.set("Content-Type", "application/x-javascript; charset=UTF-8");
    		exchange.sendResponseHeaders(response.status, sumStr.getBytes("UTF-8").length);
    		// System.out.println(sumStr);
			outputStream.write(sumStr.getBytes("UTF-8"));
    		br.close();
        }
	    
	    outputStream.flush();
	    outputStream.close();
	}

	/**
	 * 負責做靜態檔案的字串處理
	 * @param s 預處理的字串
	 * @return 處理完愁的字串
	 */
	public static String process(String s) {
		StringBuilder sb = new StringBuilder();
		char[] ch = new char[200];
		ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case '&':
				sb.append("&");
				break;
			case ' ':
				sb.append(" ");
				break;
			case '<':
				sb.append("<");
				break;
			case '>':
				sb.append(">");
				break;
			case '"':
				sb.append("\"");
				break;
			case '\t':
				sb.append("    ");
				break;
			default:
				sb.append(ch[i]);
			}
		}
		
		String string = sb.toString();
		/*string = string.replaceAll("public", "<b>public</b>");
		string = string.replaceAll("class", "<b>class</b>");
		string = string.replaceAll("static", "<b>static</b>");
		string = string.replaceAll("main", "<b>main</b>");
		string = string.replaceAll("void", "<b>void</b>");
		int n=string.lastIndexOf("//");
		if(n!=-1){
		String temp=string.substring(n);
		string=string.replaceAll(temp, "<font color=green>"+temp+"</font>");
		}*/
		string+="\n";
		return string;
		
	}
}
