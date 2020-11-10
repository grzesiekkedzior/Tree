package tree;

import tree.help.Arguments;
import tree.help.Help;
import tree.traverse.AllFiles;
import tree.traverse.Directories;

public final class Main {
    private Main() {

    }

    /**
     * Main class.
     * @param args
     */
    public static void main(String[] args) {
        String[] arg = args;
        if (arg.length > 0) {
            var directory = arg[0];
            var argument = arg[1];
            if (argument.equals(Arguments.ALL_FILES.getArgs())) {
                new AllFiles().printTree(directory);
            } else if (argument.equals(Arguments.DIRECTORIES.getArgs())) {
                new Directories().printTree(directory);
            } else if (argument.equals(Arguments.HELP.getArgs())) {
                new Help(directory).printHelp();
            }
        }

        // Uncomment to test
        // new AllFiles().printTree(".");
        // new Directories().printTree(".");
        // new Help("-h").printHelp();
    }
}
