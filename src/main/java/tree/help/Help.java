package tree.help;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

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
            String helpFile = "src/main/resources/help";
            try (Stream<String> stream = new BufferedReader(
                    new FileReader(helpFile)).lines()
            ) {
                stream.forEach(x -> System.out.println(x));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
