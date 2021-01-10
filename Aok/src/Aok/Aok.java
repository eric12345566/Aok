package Aok;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Aok {
    HttpServer server;

    public void startServer(int port) throws IOException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        server = HttpServer.create(new InetSocketAddress(port), 0);
        /*server.createContext("/post", new PostHandler());
        server.createContext("/get", new GetHandler());*/
        
        server.setExecutor(threadPoolExecutor); // creates a default executor
        server.start();
    }
}
