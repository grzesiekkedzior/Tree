package tree.help;

/**
 * This class contains implementation of constance variable.
 */
public enum Arguments {
    ALL_FILES("-a"),
    DIRECTORIES("-d"),
    HELP("-h");

    private final String args;

    Arguments(String args) {
        this.args = args;
    }

    /**
     * This method returns argument which is constant.
     * @return args
     */
    public String getArgs() {
        return args;
    }
}
