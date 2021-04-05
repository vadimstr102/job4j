package ru.job4j.lsp;

public class LSPWrongExample1 {
    class Shape {
        public void drawSquare(Square square) {
        }

        public void drawCircle(Circle circle) {
        }

        public void drawShape(Shape shape) {
            if (shape instanceof Square) {
                drawSquare((Square) shape);
            } else {
                drawCircle((Circle) shape);
            }
        }
    }

    class Square extends Shape {
    }

    class Circle extends Shape {
    }

    // При добавлении нового класса-наследника Shape, метод drawShape() будет работать некорректно,
    // что нарушает принцип LSP.
}
