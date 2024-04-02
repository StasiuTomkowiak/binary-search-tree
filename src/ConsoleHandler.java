import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ConsoleHandler<T extends Comparable<T>> {
    BinaryTree<T> bst;
    PrintWriter printWriter;
    BufferedReader bufferedReader;
    Parser<T> parser;

    public ConsoleHandler(PrintWriter printWriter, BufferedReader bufferedReader, Parser<T> parser) {
        this.printWriter = printWriter;
        this.bufferedReader = bufferedReader;
        this.parser = parser;
        bst = new BinaryTree<T>(printWriter);
    }

    public void start() throws IOException {
        while (true) {
            String msg = bufferedReader.readLine();

            switch (msg) {
                case "1", "insert" -> {
                    try {
                        printWriter.println("(INSERT): Type in a value");
                        bst.insert(parser.parse(bufferedReader.readLine()));
                        bst.draw();

                    } catch (Exception e) {
                        printWriter.println("Exception: " + e.getMessage());
                    }
                }
                case "2", "search" -> {
                    try {
                        printWriter.println("(SEARCH): Type in a value");
                        if (bst.search(parser.parse(bufferedReader.readLine()))) {
                            printWriter.println("Value found!");
                        } else {
                            printWriter.println("Value not found!");
                        }
                    } catch (Exception e) {
                        printWriter.println("Exception: " + e.getMessage());
                    }
                }
                case "3", "delete" -> {
                    try {
                        printWriter.println("(DELETE): Type in a value");
                        bst.delete(parser.parse(bufferedReader.readLine()));

                    } catch (Exception e) {
                        printWriter.println("Exception: " + e.getMessage());
                    }
                }
                case "4", "draw" -> {
                    bst.draw();
                }
                default -> {
                    printWriter.println("Input correct command");
                }
            }
        }
    }
}
