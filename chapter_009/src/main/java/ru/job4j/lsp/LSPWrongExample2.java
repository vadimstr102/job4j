package ru.job4j.lsp;

public class LSPWrongExample2 {

    class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    class Square extends Rectangle {

        @Override
        public void setWidth(int width) {
            super.setWidth(width);
            super.setHeight(width);
        }

        @Override
        public void setHeight(int height) {
            super.setWidth(height);
            super.setHeight(height);
        }
    }

    public int calculateRectangleArea(Rectangle rectangle, int width, int height) {
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        return rectangle.getWidth() * rectangle.getHeight();
    }

    // В методе calculateRectangleArea() нарушается постусловие. При передаче в него экземпляра класса Rectangle
    // и вызове методов setWidth() и setHeight() будет выполняться условие:
    // (this.width == width) && (this.height == height).
    // В случае с экземпляром класса Square это условие не выполнится, так как будет выполняться условие:
    // (this.width == height) && (this.height == height)
    // Это является нарушением принципа LSP.
}
