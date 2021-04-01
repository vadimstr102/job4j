package ru.job4j.lsp;

public class LSPWrongExample3 {
    class Storage {
        protected String[] array;

        public Storage(String[] array) {
            this.array = array;
        }

        public void load() {
            if (array.length == 0) {
                throw new IllegalArgumentException("Small storage size!");
            } else {
                System.out.println("Load start");
                //do something
            }
        }
    }

    class GoodsStorage extends Storage {
        public GoodsStorage(String[] array) {
            super(array);
        }

        @Override
        public void load() {
            if (array.length < 10) {
                throw new IllegalArgumentException("Small storage size!");
            } else {
                System.out.println("Load start");
                //do something
            }
        }
    }
    // При переопределении метода load() в классе GoodsStorage, происходит усиление предусловия, что является нарушением
    // принципа LSP.
}
