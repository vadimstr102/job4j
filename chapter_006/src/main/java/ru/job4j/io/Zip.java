package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public List<File> seekBy(String root, String ext) {
        return Search.files(root, file -> !(file.getName().contains(ext)));
    }

    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Args arguments = new Args(args);
        Zip zip = new Zip();
        zip.pack(zip.seekBy(arguments.directory(), arguments.exclude()), new File(arguments.output()));
    }
}
