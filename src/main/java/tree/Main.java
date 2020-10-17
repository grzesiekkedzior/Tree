package tree;

public final class Main {
    private Main() {

    }

    /**
     * Main class.
     * @param args
     */
    public static void main(String[] args) {
        String directory = ".";
        if (args.length > 0) {
            directory = args[0];
        }
        (new Tree()).print(directory);
    }
}
