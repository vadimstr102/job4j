package ru.job4j.searchfiles;

public class ValidateKeys {
    public static boolean validate(String[] args) {
        if (args.length == 7 && args[0].equals("-d") && args[2].equals("-n") && args[5].equals("-o")
                && (args[4].equals("-m") || args[4].equals("-f") || args[4].equals("-r"))) {
            return true;
        } else {
            StringBuilder message = new StringBuilder();
            message.append("One or more arguments are not valid.");
            message.append(System.lineSeparator());
            message.append("Use a valid query:");
            message.append(System.lineSeparator());
            message.append("java -jar find.jar -d ROOT_FOLDER_PATH -n SEARCH_FILE -m/-f/-r -o LOG_FILE_PATH");
            message.append(System.lineSeparator());
            message.append("Where:");
            message.append(System.lineSeparator());
            message.append("-m - if SEARCH_FILE is a file mask");
            message.append(System.lineSeparator());
            message.append("-f - if SEARCH_FILE is a full file name");
            message.append(System.lineSeparator());
            message.append("-r - if SEARCH_FILE is a regular expression");
            throw new IllegalArgumentException(message.toString());
        }
    }
}
