package ru.job4j.isp;

public class ISPWrongExample1 {

    interface IWorker {
        void work();

        void sleep();
    }

    class HumanWorker implements IWorker {

        @Override
        public void work() {
            System.out.println("I work");
        }

        @Override
        public void sleep() {
            System.out.println("I sleep");
        }
    }

    class RobotWorker implements IWorker {

        @Override
        public void work() {
            System.out.println("I work");
        }

        @Override
        public void sleep() {
            throw new UnsupportedOperationException("I don't need sleep!");
        }
    }

    /*
     * Роботу не нужно спать, но класс RobotWorker вынужден реализовывать метод sleep().
     * Это является нарушением принципа ISP.
     * */
}
