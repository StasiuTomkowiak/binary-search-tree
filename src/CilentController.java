import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CilentController {
    public static void main(String[] args) {
        try{
            Socket client=new Socket("localhost", 3568);

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            Console console = System.console();
            String text;

            do {
                text = console.readLine("Enter text: ");
                out.println(text);
                System.out.println(in.readLine());

            } while (!text.equals("end"));

            client.close();

        }catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}