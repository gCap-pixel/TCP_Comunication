package client;

public class ClientMain {
    private static String stringa;

    public static void main(String[] args) {
        Client client = new Client("gab");
        client.connetti();
        while(!stringa.equals("stop")) {
            client.invia();
            client.ricevi();
        }
    }

}
