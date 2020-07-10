package ru.job4j.searchfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Search {
    private Map<String, String> getArgumentsMap(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(args[0], args[1]);
        map.put(args[2], args[3]);
        map.put(args[5], args[6]);
        return map;
    }

    private Predicate<Path> getPredicate(String searchFile, String searchArg) {
        Pattern pattern;
        switch (searchArg) {
            case "-m":
                pattern = Pattern.compile(preparePattern(searchFile));
                return path -> pattern.matcher(path.getFileName().toString()).matches();
            case "-f":
                return path -> path.getFileName().toString().equals(searchFile);
            case "-r":
                pattern = Pattern.compile(searchFile);
                return path -> pattern.matcher(path.getFileName().toString()).matches();
            default:
                return path -> true;
        }
    }

    private String preparePattern(String pattern) {
        StringBuilder sb = new StringBuilder();
        for (char c : pattern.toCharArray()) {
            if (c == '*') {
                sb.append(".*");
            } else if (c == '.') {
                sb.append("\\.");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        ValidateKeys.validate(args);
        Search search = new Search();
        Map<String, String> map = search.getArgumentsMap(args);

        Path rootFolder = Paths.get(map.get("-d"));
        String searchFile = map.get("-n");
        String searchArg = args[4];
        String logFilePath = map.get("-o");

        System.out.println("Files search started...");
        SearchFiles searchFiles = new SearchFiles(search.getPredicate(searchFile, searchArg));
        Files.walkFileTree(rootFolder, searchFiles);
        LogWriter.write(searchFiles.getFiles(), logFilePath);
        System.out.printf("Files search completed. See the result in the log: %s", logFilePath);
    }
}
