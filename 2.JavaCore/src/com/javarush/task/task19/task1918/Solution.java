package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[] {"span"};
        //
        if (args.length != 1) {
            System.out.println("Illegal argument");
            return;
        }

        String tag = args[0];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) stringBuilder.append(fileReader.readLine());
        fileReader.close();

        Document htmlFile = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
        Elements elements = htmlFile.getElementsByTag(tag);
        for (Element element : elements) System.out.println(element);
    }
}