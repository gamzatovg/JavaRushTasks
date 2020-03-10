package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content; // видео
    private String name; // имя/название
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках (используем long, чтобы избежать проблем с округлением)
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits > 0 ? initialAmount/hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getAmountPerOneSecond() {
        return amountPerOneDisplaying * 1000 / duration;
    }

    public void revalidate() {
        if (hits <= 0)
            //Бросать UnsupportedOperationException, если количество показов не положительное число
            throw new UnsupportedOperationException();
        //Уменьшать количество показов
        hits--;
    }

    @Override
    public String toString() {
        return name + " is displaying... " + amountPerOneDisplaying
                + ", " + amountPerOneDisplaying * 1000 / duration;
    }
}
