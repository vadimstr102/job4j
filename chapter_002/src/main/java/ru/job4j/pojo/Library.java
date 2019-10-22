package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 448);
        Book headFirst = new Book("Izuchaem Java", 708);
        Book shildt = new Book("Java 8. Polnoe rukovodstvo", 1377);
        Book ekkel = new Book("Filosofia Java", 1170);

        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = headFirst;
        books[2] = shildt;
        books[3] = ekkel;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ": " + bk.getPages() + " pages.");
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("\nПоменяли первую и последнюю книги местами:");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ": " + bk.getPages() + " pages.");
        }

        System.out.println("\nКниги с именем \"Clean code\":");
        String s = "Отсутствуют.";
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean Code")) {
                s = bk.getName() + ": " + bk.getPages() + " pages.";
            }
        }
        System.out.println(s);
    }
}
