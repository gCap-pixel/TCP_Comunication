package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server(int port) {
        this.port = port;

        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            System.err.println("La porta " + port + " non è stata trovata o è occupata");
        }
    }

    public Socket attendi() {
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Il server ha accettato la comunicazione");
            return clientSocket;
        } catch (IOException e) {
            throw new RuntimeException("Errore durante l'attesa" );
        }
    }

    public void leggi(){
        try{
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(inputStream));
            String testo =  br.readLine();
            System.out.println("Testo ricevuto: " + testo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrivi() {
    }
}
