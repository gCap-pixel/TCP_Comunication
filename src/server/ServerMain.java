package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMain {

    private static String stringa;

    public static void main(String[] args) {
        int port = 5000;
        Server server = new Server(5000);
        try {
            ServerSocket serverSocket = new ServerSocket(port);
        }
        catch (IOException e){
            System.out.println("errore");
        }
        stringa = server.getTesto();
        server.attendi();
        while (!stringa.equals("stop")){
            server.leggi();
            server.scrivi();
            stringa = server.getTesto();
        }
        server.chiudi();
    }
}
