import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiThread extends Thread {
    private Socket client;
 
    public MultiThread(Socket client) {
        this.client = client;
    }
 
    @Override
    public void run() {

        try {
            InputStream input = client.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
    
            OutputStream output = client.getOutputStream();
            PrintWriter out = new PrintWriter(output, true);
                        
            String treeType = in.readLine();

            if (treeType.compareTo("int")==0)
            {
                out.println("int chosen");
                ClientHandler<Integer> clientHandler = new ClientHandler<Integer>(out, in,new ParseINT());
                clientHandler.handle();
                
            }

            else if (treeType.compareTo("double") == 0)
            {
                out.println("double chosen");
                ClientHandler<Double> clientHandler = new ClientHandler<Double>(out, in,new ParseDOUBLE());
                clientHandler.handle();
                
            }
            
            else if (treeType.compareTo("string") == 0)
            {
                out.println("double chosen");
                ClientHandler<String> clientHandler = new ClientHandler<String>(out, in,new ParseSTRING());
                clientHandler.handle();
                
            }
            else {
                out.println("wrong variable");
            }
            
            client.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
