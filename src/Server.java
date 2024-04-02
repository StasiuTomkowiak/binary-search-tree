import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(3000);
            while (true) {
                Socket client = server.accept();
                System.out.println("New Connection established");
                new ClientThread(client).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
