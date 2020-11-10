package tree.root;

import java.io.File;

public interface Tree {

    /**
     * Print quantity of directories and files.
     * @param directory
     */
    void printNumbersOfFiles(String directory);

    /**
     * Counting directories and variables.
     * @param file
     */
    void register(File file);

    /**
     * Walking recursively through by directories tree.
     * @param folder
     * @param prefix
     */
    void walk(File folder, String prefix);

    /**
     * Create leaf for each recursive root.
     * @param prefix
     * @param file
     * @param leftLeaf
     * @param rightLeaf
     */
    void createLeaf(String prefix, File file,
                    String leftLeaf, String rightLeaf);

    /**
     * Print tree on a console.
     * @param directory
     */
    void printTree(String directory);
}
