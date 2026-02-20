package server;

import java.util.Scanner;

public class ServerMain {
    private static String stringa = "";

    public static void main(String[] args) {
        int port = 1255;
        Server server = new Server(port);
        Scanner tastiera = new Scanner(System.in);

        server.attendi();

        while (stringa != null && !stringa.equals("stop")) {
            server.leggi();
            stringa = server.getTesto();

            if (stringa == null || stringa.equals("stop")) {
                server.chiudi();
            }

            System.out.print("Risposta del Server: ");
            String risposta = tastiera.nextLine();
            server.scrivi(risposta);

            if (risposta.equals("stop")) {
                server.chiudi();
            }
        }

        tastiera.close();
        server.chiudi();
    }
}
