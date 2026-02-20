package client;

import java.util.Scanner;

public class ClientMain {
    
    private static String stringa = "";

    public static void main(String[] args) {
        Client client = new Client("gab");
        Scanner tastiera = new Scanner(System.in);

        client.connetti();

        while(stringa != null && !stringa.equals("stop")) {
            System.out.print("Scrivi messaggio per il server: ");
            stringa = tastiera.nextLine();

            client.invia(stringa);

            if (!stringa.equals("stop")) {
                client.ricevi();
                stringa = client.getTesto();
            }
        }

        tastiera.close();
        client.chiudi();
        System.out.println("Comunicazione chiusa.");
    }
}
