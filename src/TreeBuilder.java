import java.util.ArrayList;

public class TreeBuilder<T extends Comparable<T>>{
    private Node<T> root;

    public void insert(T element)
    {
        root = insertRec(element, root);
    }

    public Node<T> insertRec(T element, Node<T> prev){
        if(prev==null){
           root=new Node<T>(element);
        }
        if(element.compareTo(prev.element)<0){
            prev.left = insertRec(element, prev.left);
        }else if(element.compareTo(prev.element)>0){
            prev.right = insertRec(element, prev.right);
        }
        return prev;
    }

    //not sure yet
    public void delete(T element) {
        root = nodeDeleter(element, root);
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
        while(prev!=null){
            if( element.compareTo(prev.element)==0){
                return true;
            }
            if( element.compareTo(prev.element)<0){ 
            return isElement(element, prev.left);
            }else{
            return isElement(element, prev.right);
        }}return (Boolean) null;
    }

    public ArrayList<T> draw(){ 
        ArrayList<T> tree=new ArrayList<>();
        toString(root,tree); 
        return tree;
      }
    private void toString(Node<T> prev,ArrayList<T> tree){ 
        if( prev!=null ){
          toString(prev.left,tree);
          tree.add(prev.element);
          toString(prev.right,tree);
        }
    }
}
