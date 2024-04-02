import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientHandler<T extends Comparable <T>>{
    TreeBuilder<T> binaryTree = new TreeBuilder<T>();
    PrintWriter output;
    BufferedReader input;
    Pareser<T> pareser;
    
    public ClientHandler(PrintWriter printWriter, BufferedReader bufferedReader, Pareser<T> pareser)
    {
        this.output = printWriter;
        this.input = bufferedReader;
        this.pareser=pareser;
    }

    public void handle() throws IOException
    {
        while (true)
        {
            String message = input.readLine();

            if (message.compareTo("insert")==0){
                try{
                    output.println("give variable: ");
                    binaryTree.insert(pareser.parse(input.readLine()));
                }
                catch(NumberFormatException e){
                    output.println(e.getMessage());
                } 
            }else if (message.compareTo("draw")==0){
                try{
                    
                    output.println(binaryTree.draw());
                }
                catch(NumberFormatException e){
                    output.println(e.getMessage());
                }  
            }else if(message.compareTo("search")==0){
                try{
                    output.println("give variable: ");
                    T newInput=pareser.parse(message);
                    binaryTree.search(newInput);
                }
                catch(NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }else if(message.compareTo("delete")==0){
                try{
                    output.println("give variable: ");
                    T newInput=pareser.parse(message);
                    binaryTree.delete(newInput);
                }
                catch(NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}