package tree.traverse;

import tree.root.AbstractTree;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;
import static com.diogonunes.jcolor.Attribute.BOLD;

public final class Directories extends AbstractTree {

    @Override
    public void createLeaf(String prefix, File file, String s, String s2) {
        if (file.isDirectory()) {
            System.out.println(prefix +  s
                    + colorize(file.getName(), BOLD(), BLUE_TEXT()));
        }
        if (file.isDirectory()) {
            walk(file, prefix + s2);
        }
    }

    @Override
    public void walk(File folder, String prefix) {
        File file;
        List<File> files = Arrays.stream(folder.listFiles())
                .filter(x -> x.isDirectory())
                .collect(Collectors.toList());

        File[] directoryList = files.stream().toArray(File[]::new);
        Arrays.sort(directoryList);

        for (int index = 0; index < directoryList.length; index++) {
            file = directoryList[index];
            if (file.getName().charAt(0) == '.') {
                continue;
            }
            register(file);

            if (index == directoryList.length - 1) {
                createLeaf(prefix, file, "└── ", "    ");
            } else {
                createLeaf(prefix, file, "├── ", "│   ");
            }
        }
    }

    @Override
    public void printTree(String directory) {
        System.out.println(directory);
        walk(new File(directory), "");
        printNumbersOfFiles(directory);
    }
}
