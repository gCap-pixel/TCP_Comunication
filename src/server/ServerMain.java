package server;

public class ServerMain {
<<<<<<< HEAD

    private static String stringa = "";

    public static void main(String[] args) {
        int port = 1255;
        Server server = new Server(port);

=======
    private static String stringa = "";

    public static void main(String[] args) {
        Server server = new Server(1255);
>>>>>>> 8116581 (modifica del ciclo while per poter mandare più messaggi)
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
