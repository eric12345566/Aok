package Aok;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Aok {
    private HttpServer server;
    private ArrayList<AokRouter> aokRoutersList = new ArrayList<AokRouter>();
    private int port;

    public Aok(int port) throws IOException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        this.port = port;

        server = HttpServer.create(new InetSocketAddress(this.port), 0);
        server.setExecutor(null); // creates a default executor

        server.createContext("/assets", new AssetsRouter());
    }

    public void startServer(){
        server.start();
        System.out.println("<AoK> Starting Server at port: " + port);
    }

    public void addRouter(String path, AokRouter handler){
        server.createContext(path, (HttpHandler) handler);
        aokRoutersList.add(handler);
    }
}
