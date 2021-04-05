package ru.job4j.dip;

public class DIPWrongExample1 {
    class ConsolePrinter {
        public void print(String text) {
            System.out.println(text);
        }
    }

    class Book {
        private String text;
        private ConsolePrinter consolePrinter = new ConsolePrinter();

        public Book(String text) {
            this.text = text;
        }

        public void print() {
            consolePrinter.print(text);
        }
    }

    /*
     * Класс Book зависит от конкретного класса ConsolePrinter, и распечатать текст книги можно только на консоль.
     * Это является нарушением принципа DIP.
     * */
}
