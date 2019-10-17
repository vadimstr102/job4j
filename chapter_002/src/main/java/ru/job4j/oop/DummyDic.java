package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String result = "Неизвестное слово " + eng;
        return result;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String perevod = dic.engToRus("Dummy");
        System.out.println(perevod);
    }
}
