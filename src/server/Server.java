package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.err.println("Errore: porta " + port + " occupata.");
        }
    }

    public void attendi() {
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Il server ha accettato la comunicazione");
        } catch (IOException e) {
            throw new RuntimeException("Errore durante l'attesa");
        }
    }

    public void leggi() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            // CORREZIONE: rimosso "String" per aggiornare l'attributo di classe
            testo = br.readLine();

            System.out.println("Testo ricevuto: " + testo);
        } catch (IOException e) {
            testo = null;
        }
    }

    public void scrivi() {
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);

            // USO DI \n COME RICHIESTO
            pw.print("bene, tu?\n");
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTesto() {
        return testo;
    }

    public void chiudi() {
        try {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            System.out.print("errore");
        }
    }
}
