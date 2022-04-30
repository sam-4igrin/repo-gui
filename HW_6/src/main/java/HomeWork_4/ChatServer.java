package HomeWork_4;

import java.net.ServerSocket;

public class ChatServer {
    int counter = 0;
    ServerSocketThread server;

    public void start(int port) {
        if (server !=null && server.asAlive()) {
            System.out.println("Server already started");
        } else {
            server = new ServerSocketThread("Chat server " + counter++, port);
        }
    }


    public void stop() {
        if (server == null || !server.isAlive()) {
            System.out.println("Server is not running");
        } else {
            server.interrupt();
        }

    }
}

