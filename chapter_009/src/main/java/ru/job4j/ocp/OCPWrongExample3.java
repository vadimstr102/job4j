package ru.job4j.ocp;

import java.util.List;

public class OCPWrongExample3 {

    static class WrongClass {

        static class Shape {
        }

        static class Circle extends Shape {
            public double radius;

            public Circle(double radius) {
                this.radius = radius;
            }
        }

        static class Rectangle extends Shape {
            public double a, b;

            public Rectangle(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }

        static class AreaCalculator {

            public double calculate(Shape shape) {
                if (shape instanceof Circle) {
                    Circle circle = (Circle) shape;
                    return Math.PI * Math.pow(circle.radius, 2);
                } else if (shape instanceof Rectangle) {
                    Rectangle rectangle = (Rectangle) shape;
                    return rectangle.a * rectangle.b;
                }
                return 0;
            }
        }
    }

    //Если нам понадобится вычислить площадь квадрата, то нужно будет изменить метод calculate() в классе AreaCalculator.
    // Это нарушит принцип открытости/закрытости, согласно которому мы можем не изменять, а только расширять.
    // Правильный вариант:

    static class GoodClass {
        interface Shape {
            double calculateArea();
        }

        static class Circle implements Shape {
            private double radius;

            public Circle(double radius) {
                this.radius = radius;
            }

            @Override
            public double calculateArea() {
                return Math.PI * Math.pow(radius, 2);
            }
        }

        static class Rectangle implements Shape {
            private double a, b;

            public Rectangle(int a, int b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public double calculateArea() {
                return a * b;
            }
        }

        static class Square implements Shape {
            private double a;

            public Square(int a) {
                this.a = a;
            }

            @Override
            public double calculateArea() {
                return a * a;
            }
        }

        static class AreaCalculator {

            public static void main(String[] args) {
                List<Shape> list = List.of(new Circle(5), new Rectangle(6, 7), new Square(8));
                list.forEach(shape -> System.out.println(shape.calculateArea()));
            }
        }
    }
}
