package tree.help;


public final class Help {

    private String arg;

    /**
     * This class print help file on a consol.
     * @param arg
     */
    public Help(String arg) {
        this.arg = arg;
    }

    /**
     * Print only which args program should use.
     */
    public void printHelp() {
        if (arg.equals(Arguments.HELP.getArgs())) {
            System.out.println(
                    "\t------------------ Listing options -----------------\n\n"
                    + "\t  -a            All files are listed.\n"
                    + "\t  -d            List directories only.\n"
                    + "\t  -L level      Descend only level directories deep."
                    + "\t  -ds           List directories with auto "
                            + "generate size (Kb, Mb, Gb");
        }
    }
}
