package client;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private int port;
    private String testo;

    public Client(String nome) {
        this.port = 1255;
        this.testo = "true";
    }

    public void connetti() {
        try {
            socket = new Socket("localhost", port);
        } catch (Exception e) {
            System.out.println("errore il server non risponde");
        }
    }

    public void invia(String messaggio) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);

            // USO DI \n COME RICHIESTO
            pw.print(messaggio + "\n");
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ricevi() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            // CORREZIONE: rimosso "String" per aggiornare l'attributo di classe
            testo = br.readLine();

            System.out.println("il server dice: " + testo);
        } catch (IOException e) {
            testo = null;
        }
    }

    public String getTesto() {
        return testo;
    }

    public void chiudi() {
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.out.println("errore nella chiusura");
        }
    }
}
