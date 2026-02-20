package server;

public class ServerMain {

    private static String stringa = "";

    public static void main(String[] args) {
        int port = 1255;
        Server server = new Server(port);

        server.attendi();

        while (stringa != null && !stringa.equals("stop")) {
            server.leggi();
            stringa = server.getTesto();

            if (stringa != null && !stringa.equals("stop")) {
                server.scrivi();
            }
        }
        server.chiudi();
    }
}
