package server;

public class ServerMain {

    private static String stringa = "";

    public static void main(String[] args) {
        Server server = new Server(1255);
        server.attendi();

        while (stringa != null && !stringa.equals("stop")) {
            server.leggi();
            stringa = server.getTesto();

            if (stringa != null && !stringa.equals("stop")) {
                server.scrivi();
            }
        }
        server.chiudi();
        System.out.println("Server spento.");
    }
}
