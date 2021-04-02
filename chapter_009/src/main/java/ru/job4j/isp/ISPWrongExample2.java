package ru.job4j.isp;

public class ISPWrongExample2 {

    interface Phone {
        void call();

        void sendMessage();

        void takePhoto();
    }

    class SmartPhone implements Phone {

        @Override
        public void call() {
            System.out.println("Call");
        }

        @Override
        public void sendMessage() {
            System.out.println("Send message");
        }

        @Override
        public void takePhoto() {
            System.out.println("Take photo");
        }
    }

    class WiredPhone implements Phone {

        @Override
        public void call() {
            System.out.println("Call");
        }

        @Override
        public void sendMessage() {
            throw new UnsupportedOperationException("I can't send messages!");
        }

        @Override
        public void takePhoto() {
            throw new UnsupportedOperationException("I do not know how to take pictures!");
        }
    }

    /*
     * Проводной телефон не умеет отправлять сообщения и фотографировать, но класс WiredPhone
     * вынужден реализовывать методы sendMessage() и takePhoto().
     * Это является нарушением принципа ISP.
     * */
}
