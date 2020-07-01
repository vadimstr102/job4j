package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Vadim Timofeev
 */
public class SearchNewVersion {

    public static List<String> search(Path root, String ext) throws IOException {
        SearchFilesByExtension searchFiles = new SearchFilesByExtension(ext);
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getResult();
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException(
                    "Root folder and/or file extension is null. "
                            + "Usage java -jar searchnewversion.jar ROOT_FOLDER FILE_EXTENSION."
            );
        }
        Path root = Paths.get(args[0]);
        List<String> list = SearchNewVersion.search(root, args[1]);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
