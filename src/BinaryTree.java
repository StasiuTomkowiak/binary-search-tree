import java.io.PrintWriter;

public class BinaryTree<T extends Comparable<T>> {
    private node<T> root ;
    private PrintWriter printWriter;

    public BinaryTree(PrintWriter printWriter) {
        root = null;
        this.printWriter = printWriter;
    }
    static class node<T> {
        T key;
        node<T> left, right;
    };

    private node<T> newNode(T item)
    {
        node<T> temp = new node<T>();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    public void insert(T key) {
        root = insert(root, key);
    }
    private node<T> insert(node<T> node, T key)
    {
        // If the tree is empty, return a new node
        if (node == null)
            return newNode(key);

        // Otherwise, recur down the tree
        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key);
        }

        // Return the node
        return node;
    }

    public boolean search(T key) {
        return search(root, key);
    }

    private boolean search(node<T> node, T key) {
        // Base Cases: root is null or key is present at root
        if (node == null){
            return false;
        }
        if (node.key == key) {
            return true;
        }

        if (key.compareTo(node.key) < 0){
            return search(node.left, key);
        }

        return search(node.right, key);
    }



    public void printTree() {
        printWriter.println(preorder("", root));
    }

    private String preorder(String string, node<T> node) {
        if (node == null) {
            return string;
        }

        String temp = string;

        temp = temp + node.key.toString() + " ";
        temp = preorder(temp, node.left);
        temp = preorder(temp, node.right);

        return temp;
    }

    private String printTree(String prefix, node<T> node, boolean isLeft, String data) {
        if (node != null) {
            String temp = data + prefix + (isLeft ? "|-- " : "\\-- ") + node.key + "\n";
            printTree(prefix + (isLeft ? "|   " : "    "), node.left, true, temp);
            printTree(prefix + (isLeft ? "|   " : "    "), node.right, false, temp);

            return temp;
        }
        return data;
    }

    public node<T> delete(T key) {
        return delete(root, key);
    }

    private node<T> delete(node<T> node, T key){
        if (node == null) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
            return node;
        }

        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            node<T> successorParent = node;

            node<T> successor = node.right;
            while (successor.left !=null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (successorParent != node) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }

            node.key = successor.key;

            return node;
        }



    }
}
