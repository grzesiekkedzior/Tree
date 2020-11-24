package tree.traverse;

import tree.root.AbstractTree;

import java.io.File;
import java.text.DecimalFormat;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BOLD;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;
import static com.diogonunes.jcolor.Attribute.RED_TEXT;

public final class FileContentSize extends AbstractTree {

    @Override
    public void createLeaf(String prefix, File file, String s, String s2) {
        if (file.isDirectory()) {
            System.out.println(prefix +  s
                    + colorize(file.getName(), BOLD(), BLUE_TEXT()));
        } else {
            System.out.println(prefix
                    + s + file.getName()
                    + colorize(" " + getFileSize(file), RED_TEXT()));
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

    private String getFileSize(File file) {
        var size = file.length();
        DecimalFormat df = new DecimalFormat("0.00");

        final float sizeKb = 1024.0f;
        var sizeMb = sizeKb * sizeKb;
        var sizeGb = sizeMb * sizeKb;
        var sizeTerra = sizeGb * sizeKb;

        if (size < sizeMb) {
            return df.format(size / sizeKb) + " Kb";
        } else if (size < sizeGb) {
            return df.format(size / sizeMb) + " Mb";
        } else if (size < sizeTerra) {
            return df.format(size / sizeGb) + " Gb";
        }
        return "";
    }
}
