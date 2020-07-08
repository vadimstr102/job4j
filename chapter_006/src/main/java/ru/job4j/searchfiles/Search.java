package ru.job4j.searchfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Search {
    public Map<String, String> getArgumentsMap(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(args[0], args[1]);
        map.put(args[2], args[3]);
        map.put(args[5], args[6]);
        return map;
    }

    public Predicate<Path> getPredicate(String searchFile, String searchArg) {
        switch (searchArg) {
            case "-m":
                return path -> path.getFileName().toString().contains(searchFile.substring(1));
            case "-f":
                return path -> path.getFileName().toString().equals(searchFile);
            case "-r":
                return path -> path.getFileName().toString().matches(searchFile);
            default:
                return null;
        }
    }

    public static void main(String[] args) throws IOException {
        ValidateKeys.validate(args);
        Search search = new Search();
        Map<String, String> map = search.getArgumentsMap(args);

        Path rootFolder = Paths.get(map.get("-d"));
        String searchFile = map.get("-n");
        String searchArg = args[4];
        String logFilePath = map.get("-o");

        SearchFiles searchFiles = new SearchFiles(search.getPredicate(searchFile, searchArg));
        Files.walkFileTree(rootFolder, searchFiles);
        LogWriter.write(searchFiles.getFiles(), logFilePath);
    }
}
