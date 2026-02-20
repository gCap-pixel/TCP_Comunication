package client;

public class ClientMain {
    private static String stringa = "true";

    public static void main(String[] args) {
        Client client = new Client("gab");
        client.connetti();
        while (stringa != null && !stringa.equals("stop")) {
            client.invia("ciao");
            client.ricevi();
            stringa = client.getTesto();
            if (stringa == null) {
                System.out.println("Connessione persa col server.");
                break;
            }
            client.chiudi();
        }

    }
}
