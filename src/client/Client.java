package client;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private  String nome;
    private  String colore;
    private Socket socket;
    private String nomeServer;
    private int port = 5000;

    public Client(String nome) {
        this.nome = nome;
        this.port = 5000;
    }

    public void connetti(){
        try  {
            socket = new Socket("localhost", port);
        }
        catch(Exception e){
            System.out.println("errore il server non risponde");
        }
    }
    public void invia(){
        try {
            OutputStream outputStream =  socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.print("ciao come va?");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void chiudi(){
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("errore nella chiusura");
        }
    }
}
