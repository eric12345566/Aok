import java.io.*;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/post", new PostHandler());
        server.createContext("/get/eric", new Get2Handler());
        server.createContext("/get", new GetHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static class GetHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Call /get");
            System.out.println("Method: "+ httpExchange.getRequestMethod());
            String param = httpExchange.getRequestURI().getQuery();
            System.out.println("URI: "+httpExchange.getRequestURI());
            System.out.println("Param:"+ param);
            httpExchange.sendResponseHeaders(200, 0);
            OutputStream os = httpExchange.getResponseBody();
            os.write(param.getBytes());
            os.close();
        }
    }

    public static class Get2Handler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Call /get/eric");
            System.out.println("Method: "+ httpExchange.getRequestMethod());
            String param = httpExchange.getRequestURI().getQuery();
            System.out.println("URI: "+httpExchange.getRequestURI());
            System.out.println("Param:"+ param);
            httpExchange.sendResponseHeaders(200, 0);
            OutputStream os = httpExchange.getResponseBody();
            os.write(param.getBytes());
            os.close();
        }
    }

    public static class PostHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Method: "+  httpExchange.getRequestMethod());
            InputStream is = httpExchange.getRequestBody();
            String response = is2string(is);
            System.out.println("response: "+  response);
            is.close();
            httpExchange.sendResponseHeaders(200, response.length());
            Headers headers = httpExchange.getResponseHeaders();
            headers.set("Content-Type", "application/json; charset=utf8");
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        private String is2string(InputStream is) throws IOException {
            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];
            final StringBuilder out = new StringBuilder();
            Reader in = new InputStreamReader(is, "UTF-8");
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
            return out.toString();
        }
    }

}