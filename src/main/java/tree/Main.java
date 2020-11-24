package tree;

import tree.help.Arguments;
import tree.help.Help;
import tree.traverse.AllFiles;
import tree.traverse.Directories;
import tree.traverse.FileContentSize;

public final class Main {
    private Main() {

    }

    /**
     * Main class.
     * @param args
     */
    public static void main(String[] args) {

        if (args.length == 1) {
            var argument = args[0];
            if (argument.equals(Arguments.HELP.getArgs())) {
                new Help(argument).printHelp();
            } else {
                message();
            }

        } else if (args.length == 2) {
            var directory = args[0];
            var argument = args[1];
            if (argument.equals(Arguments.ALL_FILES.getArgs())) {
                new AllFiles().printTree(directory);
            } else if (argument.equals(Arguments.DIRECTORIES.getArgs())) {
                new Directories().printTree(directory);
            } else if (argument.equals(Arguments.SIZE.getArgs())) {
                new FileContentSize().printTree(directory);
            } else {
                message();
            }

        } else {
            message();
        }

        // Uncomment to test
        // new AllFiles().printTree(".");
        // new Directories().printTree(".");
        // new Help("-h").printHelp();
        // new FileContentSize().printTree(".");
    }

    private static void message() {
        System.out.println("WRONG ARGUMENTS!");
    }
}
