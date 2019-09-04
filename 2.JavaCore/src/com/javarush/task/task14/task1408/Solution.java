package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            switch (country) {
                case Country.RUSSIA:
                    return hen = new RussianHen();
                case Country.UKRAINE:
                    return hen = new UkrainianHen();
                case Country.MOLDOVA:
                    return hen = new MoldovanHen();
                case Country.BELARUS:
                    return hen = new BelarusianHen();
                default:
                    return hen;
            }
        }
    }
}
