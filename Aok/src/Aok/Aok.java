package Aok;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Aok {
    HttpServer server;
    ArrayList<AokRouter> aokRoutersList = new ArrayList<AokRouter>();

    public void startServer(int port) throws IOException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(threadPoolExecutor); // creates a default executor
        server.start();
        System.out.println("<AoK> Starting Server at port: " + port);
    }

    public void addRouter(String path, AokRouter handler){
        server.createContext(path, (HttpHandler) handler);
        aokRoutersList.add(handler);
    }
}
