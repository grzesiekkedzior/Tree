package tree;

import java.io.File;
import java.util.Arrays;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.YELLOW_TEXT;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;

/**
 * This class print directories and files using tree way.
 */
public class Tree {

    private int dirCount;
    private int fileCount;

    /**
     * Set default values for instance variables.
     */
    public Tree() {
        this.dirCount = 0;
        this.fileCount = 0;
    }

    /**
     * Print quantity of directories and files.
     * @param directory
     */
    public void print(String directory) {
        System.out.println(directory);
        walk(new File(directory), "");
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
    private void register(File file) {
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
    private void walk(File folder, String prefix) {
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

    private void createLeaf(String prefix, File file, String s, String s2) {
        if (file.isDirectory()) {
            System.out.println(prefix + s
                    + colorize(file.getName(), BLUE_TEXT()));
        } else {
            System.out.println(prefix + s + file.getName());
        }
        if (file.isDirectory()) {
            walk(file, prefix + s2);
        }
    }
}
