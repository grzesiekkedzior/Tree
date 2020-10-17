package tree;

import java.io.File;
import java.util.Arrays;

/**
 * This class print directories and files using tree way.
 */
public class Tree {
    /**Count directories.*/
    private int dirCount;

    /**Count files.*/
    private int fileCount;

    /**
     * Set default values for instance variables.
     */
    public Tree() {
        this.dirCount = 0;
        this.fileCount = 0;
    }

    /**
     * Print tree.
     * @param directory
     */
    public void print(String directory) {
        System.out.println(directory);
        walk(new File(directory), "");
        System.out.println("\n"
                + this.dirCount
                + " directories, "
                + this.fileCount
                + " files");
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
                System.out.println(prefix + "└── " + file.getName());
                if (file.isDirectory()) {
                    walk(file, prefix + "    ");
                }
            } else {
                System.out.println(prefix + "├── " + file.getName());
                if (file.isDirectory()) {
                    walk(file, prefix + "│   ");
                }
            }
        }
    }
}
