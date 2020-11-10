package tree.traverse;

import tree.root.AbstractTree;

import java.io.File;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;

public final class Directories extends AbstractTree {

    @Override
    public void createLeaf(String prefix, File file, String s, String s2) {
        if (file.isDirectory()) {
            System.out.println(prefix + s
                    + colorize(file.getName(), BLUE_TEXT()));
        }
        if (file.isDirectory()) {
            walk(file, prefix + s2);
        }
    }

    @Override
    public void printTree(String directory) {
        System.out.println(directory);
        walk(new File(directory), "");
        printNumbersOfFiles(directory);
    }
}
