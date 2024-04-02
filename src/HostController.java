import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HostController <T extends Comparable<T>>{
    public static void main(String[] args) throws IOException{
        try{
            ServerSocket localhost=new ServerSocket(3568);
            System.out.println("host is listening");
            while (true) {
                Socket client = localhost.accept();
                new MultiThread(client).start();
                System.out.println("new client added");
            }

        }catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    
    }

/* 
    protected Node<T> root;


    public Node<T> insert(T element, Node<T> prev){
        if(prev==null){
           root=new Node<T>(element);
        }
        if(element.compareTo(prev.element)<0){
            prev.left = insert(element, prev.left);
        }else if(element.compareTo(prev.element)>0){
            prev.right = insert(element, prev.right);
        }
        return prev;
    }

    public void delete(T element) {
        root = nodeDeleter(element,root);
    }
    public Node<T> nodeDeleter(T element,Node<T> prev) {
        if (root == null) {
            return null;
        }
        if (element.compareTo(prev.element) < 0) {
            prev.left = nodeDeleter(element, root.left);
        } else if (element.compareTo(root.element) > 0) {
            prev.right = nodeDeleter(element, root.right);
        } else {
            // 1 or no children
            if (prev.left == null) {
                return prev.right;
            } else if (prev.right == null) {
                return prev.left;
            }    
            // 2 children
            Node<T> current=prev.right;
            while (current.left != null) {
                current = current.left;
            }
            Node<T> successor = current;
            prev.element = successor.element;
            prev.right = nodeDeleter(successor.element, prev.right);
        }
    
        return root;
    }

    public boolean search(T element){ 
        return isElement(element,root); 
    }
    private boolean isElement(T element, Node<T> prev){
        if(prev==null){
            return false;
        }
        if( element.compareTo(prev.element)==0){
            return true;
        }
        if( element.compareTo(prev.element)<0){ 
          return isElement(element, prev.left);
        }else{
          return isElement(element, prev.right);
        }
    }

    public String draw(){ 
        return toString(root); 
      }
    private String toString(Node<T> w){ 
        if( w!=null ){
          return "("+w.element+":"+toString(w.left)+":"+toString(w.right)+")";
        }
        return "()";
    }*/
}

