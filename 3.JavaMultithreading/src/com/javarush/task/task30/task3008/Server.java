package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    
    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message request = new Message(MessageType.NAME_REQUEST);
            Message response;
            String userName;
            do {
                connection.send(request);
                response = connection.receive();
                userName = response.getData();
            } while (response.getType() != MessageType.USER_NAME
                    || userName == null
                    || userName.isEmpty()
                    || connectionMap.containsKey(userName));

            connectionMap.put(userName, connection);

            connection.send(new Message(MessageType.NAME_ACCEPTED));

            return userName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            connectionMap.keySet().forEach(string -> {
                if (!string.equals(userName)) {
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, string));
                    } catch (IOException e) {
                        ConsoleHelper.writeMessage(String.format("ОШИБКА: не удалось отправить сообщение клиенту [%s].", string));
                    }
                }
            });
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;

            while (true) {
                message = connection.receive();

                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                } else {
                    ConsoleHelper.writeMessage("ОШИБКА: принятое сообщение не является текстом.");
                }
            }
        }

        @Override
        public void run() {
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            ConsoleHelper.writeMessage(String.format("Установлено новое соединение с удаленным адресом: %s.", socketAddress));

            try (Connection connection = new Connection(socket)) {
                String userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);

                //
                serverMainLoop(connection, userName);
                //

                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage(String.format("ОШИБКА: произошла ошибка при обмене данными с удаленным адресом: %s.", socketAddress));
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        connectionMap.forEach((string, connection) -> {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("ОШИБКА: не удалось отправить сообщение клиенту [%s].", string));
            }
        });
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());

        ConsoleHelper.writeMessage("Сервер запущен.");

        while (true) {
            try {
                new Handler(serverSocket.accept()).start();
            } catch (Exception e) {
                serverSocket.close();
                ConsoleHelper.writeMessage(e.getMessage());
                break;
            }
        }
    }
}
