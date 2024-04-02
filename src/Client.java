import java.io.*;
import java.net.Socket;

import java.util.Objects;


public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 3000);
            PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Console console = System.console();
            String msg;

            do {
                msg = console.readLine("$: ");
                printWriter.println(msg);
                System.out.println(bufferedReader.readLine());
            } while (!Objects.equals(msg, "exit"));

            client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
