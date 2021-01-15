package Aok;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Aok 負責與 httpserver 溝通，做一些 config。
 */
public class Aok {
    private HttpServer server;
    private ArrayList<AokRouter> aokRoutersList = new ArrayList<AokRouter>();
    private int port;

    /**
     * Aok 建構子，可以帶入port直接設定server開啟
     * @param port 設定 web Server 啟動 port 號碼
     * @throws IOException
     */
    public Aok(int port) throws IOException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        this.port = port;

        server = HttpServer.create(new InetSocketAddress(this.port), 0);
        server.setExecutor(null); // creates a default executor
    }

    /**
     * 啟動伺服器
     */
    public void startServer(){
        server.createContext("/assets", new AssetsRouter());
        server.start();
        System.out.println("<AoK> Starting Server at port: " + port);
    }

    /**
     * 註冊 Router
     * @param path 要註冊的路徑
     * @param handler 負責處理的 AokRouter
     */
    public void addRouter(String path, AokRouter handler){
        server.createContext(path, (HttpHandler) handler);
        aokRoutersList.add(handler);
    }
}
