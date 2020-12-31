import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Aok {
    ArrayList<AokRouter> aokRoutersList = new ArrayList<AokRouter>();
    public void start(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        // TODO: transfer AokRouter to createContext
        // server.createContext("/post", new PostHandler());
        // server.createContext("/get", new GetHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public void addRoute(AokRouter aokRouter){
        aokRoutersList.add(aokRouter);
    }
}
