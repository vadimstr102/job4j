package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest {
    File parent;
    File parentFile1, parentFile2, parentFile3;
    File child1File1, child1File2;
    File child2File1, child2File2;
    File child3File1, child3File2;
    File subChild1File1, subChild1File2, subChild1File3;
    File subChild2File1, subChild2File2, subChild2File3;
    File subChild3File1, subChild3File2, subChild3File3;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void start() throws IOException {
        String s = File.separator;
        /*
          Create folders structure
         */
        parent = folder.newFolder("parent");
        File child1 = folder.newFolder(parent.getName(), "child1");
        File child2 = folder.newFolder(parent.getName(), "child2");
        File child3 = folder.newFolder(parent.getName(), "child3");
        File subChild1 = folder.newFolder(parent.getName(), child1.getName(), "subChild1");
        File subChild2 = folder.newFolder(parent.getName(), child2.getName(), "subChild2");
        File subChild3 = folder.newFolder(parent.getName(), child3.getName(), "subChild3");
        /*
          Add files to folders
         */
        parentFile1 = folder.newFile(parent.getName() + s + "parent_txt.txt");
        parentFile2 = folder.newFile(parent.getName() + s + "parent_exe.exe");
        parentFile3 = folder.newFile(parent.getName() + s + "parent_doc.doc");
        child1File1 = folder.newFile(parent.getName() + s + child1.getName() + s + "child1_txt.txt");
        child1File2 = folder.newFile(parent.getName() + s + child1.getName() + s + "child1_exe.exe");
        child2File1 = folder.newFile(parent.getName() + s + child2.getName() + s + "child2_doc.doc");
        child2File2 = folder.newFile(parent.getName() + s + child2.getName() + s + "child2_txt.txt");
        child3File1 = folder.newFile(parent.getName() + s + child3.getName() + s + "child3_exe.exe");
        child3File2 = folder.newFile(parent.getName() + s + child3.getName() + s + "child3_doc.doc");
        subChild1File1 = folder.newFile(parent.getName() + s + child1.getName() + s + subChild1.getName() + s + "sub_child1_txt.txt");
        subChild1File2 = folder.newFile(parent.getName() + s + child1.getName() + s + subChild1.getName() + s + "sub_child1_exe.exe");
        subChild1File3 = folder.newFile(parent.getName() + s + child1.getName() + s + subChild1.getName() + s + "sub_child1_doc.doc");
        subChild2File1 = folder.newFile(parent.getName() + s + child2.getName() + s + subChild2.getName() + s + "sub_child2_txt.txt");
        subChild2File2 = folder.newFile(parent.getName() + s + child2.getName() + s + subChild2.getName() + s + "sub_child2_exe.exe");
        subChild2File3 = folder.newFile(parent.getName() + s + child2.getName() + s + subChild2.getName() + s + "sub_child2_doc.doc");
        subChild3File1 = folder.newFile(parent.getName() + s + child3.getName() + s + subChild3.getName() + s + "sub_child3_txt.txt");
        subChild3File2 = folder.newFile(parent.getName() + s + child3.getName() + s + subChild3.getName() + s + "sub_child3_exe.exe");
        subChild3File3 = folder.newFile(parent.getName() + s + child3.getName() + s + subChild3.getName() + s + "sub_child3_doc.doc");
    }

    @Test
    public void whenUseSearchWithTxt() {
        List<String> extensions = List.of("txt");
        List<File> result = Search.files(parent.getAbsolutePath(), extensions);
        List<File> expected = List.of(
                parentFile1,
                child1File1,
                child2File2,
                subChild1File1,
                subChild2File1,
                subChild3File1
        );
        assertThat(result.size() == expected.size(), is(true));
        assertThat(result.containsAll(expected), is(true));
    }

    @Test
    public void whenUseSearchWithDoc() {
        List<String> extensions = List.of("doc");
        List<File> result = Search.files(parent.getAbsolutePath(), extensions);
        List<File> expected = List.of(
                parentFile3,
                child2File1,
                child3File2,
                subChild1File3,
                subChild2File3,
                subChild3File3
        );
        assertThat(result.size() == expected.size(), is(true));
        assertThat(result.containsAll(expected), is(true));
    }

    @Test
    public void whenUseSearchWithDocAndExe() {
        List<String> extensions = List.of("doc", "exe");
        List<File> result = Search.files(parent.getAbsolutePath(), extensions);
        List<File> expected = List.of(
                parentFile2,
                parentFile3,
                child1File2,
                child2File1,
                child3File1,
                child3File2,
                subChild1File2,
                subChild1File3,
                subChild2File2,
                subChild2File3,
                subChild3File2,
                subChild3File3
        );
        assertThat(result.size() == expected.size(), is(true));
        assertThat(result.containsAll(expected), is(true));
    }
}
