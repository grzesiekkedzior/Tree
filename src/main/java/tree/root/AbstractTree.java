package tree.root;

import java.io.File;
import java.util.Arrays;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.YELLOW_TEXT;

/**
 * This abstract class print directories and files using tree way.
 * This is the basic skeleton for all inheriting classes.
 */
public abstract class AbstractTree implements Tree {

    private int dirCount;
    private int fileCount;

    /**
     * Default values for instance variables.
     */
    public AbstractTree() {
        this.dirCount = 0;
        this.fileCount = 0;
    }

    /**
     * Print quantity of directories and files.
     * @param directory
     */
    public void printNumbersOfFiles(String directory) {
        System.out.println(colorize("\n"
                + this.dirCount
                + " directories, "
                + this.fileCount
                + " files", YELLOW_TEXT()));
    }

    /**
     * Counting directories and variables.
     * @param file
     */
    public void register(File file) {
        if (file.isDirectory()) {
            this.dirCount += 1;
        } else {
            this.fileCount += 1;
        }
    }

    /**
     * Walking recursively through by directories tree.
     * @param folder
     * @param prefix
     */
    @Override
    public void walk(File folder, String prefix) {
        File file;
        File[] fileList = folder.listFiles();
        Arrays.sort(fileList);

        for (int index = 0; index < fileList.length; index++) {
            file = fileList[index];
            if (file.getName().charAt(0) == '.') {
                continue;
            }
            register(file);

            if (index == fileList.length - 1) {
                createLeaf(prefix, file, "└── ", "    ");
            } else {
                createLeaf(prefix, file, "├── ", "│   ");
            }
        }
    }
}
