import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ClientThread extends Thread{
    private Socket client;

    public ClientThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStreamWriter outputStream = new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            String type = bufferedReader.readLine();

            do  {
                switch (type) {
                    case "int", "integer", "Integer" -> {
                        printWriter.println("Type: INTEGER");
                        ConsoleHandler<Integer> consoleHandler = new ConsoleHandler<Integer>(printWriter, bufferedReader, new IntParser());
                        consoleHandler.start();
                    }
                    case "double", "Double" -> {
                        printWriter.println("Type: DOUBLE");
                        ConsoleHandler<Double> consoleHandler = new ConsoleHandler<Double>(printWriter, bufferedReader, new DoubleParser());
                        consoleHandler.start();
                    }
                    case "string", "String" -> {
                        printWriter.println("Type: STRING");
                        ConsoleHandler<String> consoleHandler = new ConsoleHandler<String>(printWriter, bufferedReader, new StringParser());
                        consoleHandler.start();
                    }
                    default -> {
                        printWriter.println("Choose the correct type");
                    }
                }
            } while (!Objects.equals(type, "exit"));
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
