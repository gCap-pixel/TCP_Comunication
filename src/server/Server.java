package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    private String testo;
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
        testo = testo;
    }
    public String getTesto(){
        return testo;
    }
    public void scrivi() {
        OutputStream outputStream = null;
        try {
            outputStream = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.print("bene, tu?");
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void chiudi(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.print("errore");
        }
    }
}
