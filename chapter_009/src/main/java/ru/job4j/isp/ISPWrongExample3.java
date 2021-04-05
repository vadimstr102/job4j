package ru.job4j.isp;

public class ISPWrongExample3 {
    interface Duck {
        void sound();

        void swim();

        void fly();
    }

    class MallardDuck implements Duck {
        @Override
        public void sound() {
            System.out.println("Quack-Quack");

        }

        @Override
        public void swim() {
            System.out.println("I swim");
        }

        @Override
        public void fly() {
            System.out.println("I fly");
        }
    }

    class RubberDuck implements Duck {
        @Override
        public void sound() {
            System.out.println("Squeak-Squeak");
        }

        @Override
        public void swim() {
            System.out.println("I swim");
        }

        @Override
        public void fly() {
            throw new UnsupportedOperationException("I can't fly!");
        }
    }

    /*
     * Резиновая утка не умеет летать, но класс Rubber вынужден реализовывать метод fly().
     * Это является нарушением принципа ISP.
     * */
}
