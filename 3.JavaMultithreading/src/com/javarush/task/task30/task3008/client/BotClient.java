package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String[] strings = message.split(": ", 2);

            if (strings.length != 2) return;

            String userName = strings[0];
            String messageText = strings[1];

            String pattern;
            switch (messageText) {
                case "дата":
                    pattern = "d.MM.YYYY";
                    break;
                case "день":
                    pattern = "d";
                    break;
                case "месяц":
                    pattern = "MMMM";
                    break;
                case "год":
                    pattern = "YYYY";
                    break;
                case "время":
                    pattern = "H:mm:ss";
                    break;
                case "час":
                    pattern = "H";
                    break;
                case "минуты":
                    pattern ="m";
                    break;
                case "секунды":
                    pattern = "s";
                    break;
                default:
                    return;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Calendar calendar = new GregorianCalendar();

            String result = String.format("Информация для %s: %s", userName, simpleDateFormat.format(calendar.getTime()));

            sendTextMessage(result);
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d",  (int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
