package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        @Override
        public String toString() {
            return String.format("%s\n%d\n%d", staticString, i, j);
        }

        /**
         * (Брюс Эккель - "Философия Java")
         *
         * Если вас по каким-либо причинам не прельщает реализация интерфейса Externalizable, существует и другой подход.
         * Вы можете реализовать интерфейс Serializable и добавить (заметьте, что я сказал «добавить», а не «переопределить»
         * или «реализовать») методы с именами writeObject() и readObject(). Они автоматически вызываются при сериализации
         * и восстановлении объектов. Иначе говоря, эти два метода заменят собой сериализацию по умолчанию.
         * Эти методы должны иметь жестко фиксированную сигнатуру:
         *
         *  private void writeObject(ObjectOutputStream stream) throws IOException;
         *  private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
         **/
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(staticString);
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            staticString = (String) stream.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2009\\serial.bin";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        ClassWithStatic classWithStatic = new ClassWithStatic();

        oos.writeObject(classWithStatic);

        oos.close();

        classWithStatic.staticString = "new static string";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        classWithStatic = (ClassWithStatic) ois.readObject();

        System.out.println(classWithStatic);

        ois.close();
    }
}
