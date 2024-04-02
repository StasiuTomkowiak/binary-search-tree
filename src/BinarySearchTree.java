import java.util.Scanner;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<>(data);
        } else {
            if (data.compareTo(node.data) < 0) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.data) == 0) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node<T> node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.data);
            printTree(node.left, level + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz typ drzewa: ");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.println("3. String");
        int choice = scanner.nextInt();

        BinarySearchTree<?> tree;

        switch (choice) {
            case 1:
                tree = new BinarySearchTree<Integer>();
                break;
            case 2:
                tree = new BinarySearchTree<Double>();
                break;
            case 3:
                tree = new BinarySearchTree<String>();
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        System.out.println("Dodawanie elementów do drzewa (wpisz 'q' aby zakończyć):");

        while (true) {
            if (tree instanceof BinarySearchTree<Integer>) {
                System.out.print("Wprowadź liczbę całkowitą: ");
                if (scanner.hasNextInt()) {
                    int value = scanner.nextInt();
                    ((BinarySearchTree<Integer>) tree).insert(value);
                } else {
                    String input = scanner.next();
                    if (input.equals("q")) {
                        break;
                    } else {
                        System.out.println("Nieprawidłowe dane.");
                    }
                }
            } else if (tree instanceof BinarySearchTree<Double>) {
                System.out.print("Wprowadź liczbę zmiennoprzecinkową: ");
                if (scanner.hasNextDouble()) {
                    double value = scanner.nextDouble();
                    ((BinarySearchTree<Double>) tree).insert(value);
                } else {
                    String input = scanner.next();
                    if (input.equals("q")) {
                        break;
                    } else {
                        System.out.println("Nieprawidłowe dane.");
                    }
                }
            } else if (tree instanceof BinarySearchTree<String>) {
                System.out.print("Wprowadź tekst: ");
                String value = scanner.next();
                ((BinarySearchTree<String>) tree).insert(value);
            }
        }

        System.out.println("\nDrzewo binarne:");
        tree.printTree();
    }
}
