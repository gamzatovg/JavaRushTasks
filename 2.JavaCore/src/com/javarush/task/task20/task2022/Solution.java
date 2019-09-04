package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\text.txt");
        solution.writeObject("some text");
        solution.close();

        File serialFile = new File("C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\serial.bin");

        //Serialization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serialFile));
        objectOutputStream.writeObject(solution);
        objectOutputStream.close();

        //Deserialization
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serialFile));
        Solution newSolution = (Solution) objectInputStream.readObject();
        newSolution.writeObject("some new text");
        newSolution.close();
        objectInputStream.close();
    }
}
