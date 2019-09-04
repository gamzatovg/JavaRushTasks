package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<Word>();

        nextWord:
        for (String currentWord : words) {
            Word word = new Word(currentWord);
            StringBuilder stringBuilder = new StringBuilder(currentWord);

            //Обход по всем напрввлениям (согласно цифровому блоку клавиатуры)
            for (int direction = 1; direction <= 9; direction++) {
                int letterIndex = 0;
                int row = 0; //Строка
                int column = 0; //Столбец

                if (direction == 5) direction++;
                if (direction == 3 || direction == 4 || direction == 7) column = crossword[0].length - 1;
                if (direction == 8) row = crossword.length - 1;

                int rowAccumulator = 0;
                int columnAccumulator = 1;
                while (row >= 0 && row < crossword.length && column >= 0 && column < crossword[0].length) {
                    while (column >= 0 && column < crossword[0].length && row >= 0 && row < crossword.length) {
                        if ((char) crossword[row][column] != stringBuilder.charAt(letterIndex)) {
                            letterIndex = 0;
                        } else {
                            if (letterIndex != 0 && letterIndex != stringBuilder.length() - 1) {
                                letterIndex++;
                            } else if (letterIndex == 0 && letterIndex == stringBuilder.length() - 1) {
                                word.startX = column;
                                word.startY = row;
                                word.endX = column;
                                word.endY = row;
                                list.add(word);
                                continue nextWord;
                            } else if (letterIndex == 0) {
                                letterIndex++;
                                word.startX = column;
                                word.startY = row;
                            } else if (letterIndex == stringBuilder.length() - 1) {
                                word.endX = column;
                                word.endY = row;
                                list.add(word);
                                continue nextWord;
                            }
                        }

                        switch (direction) {
                            case 1:
                                column--;
                                row++;
                                break;
                            case 2:
                                row++;
                                break;
                            case 3:
                                column++;
                                row++;
                                break;
                            case 4:
                                column--;
                                break;
                            case 6:
                                column++;
                                break;
                            case 7:
                                column--;
                                row--;
                                break;
                            case 8:
                                row--;
                                break;
                            case 9:
                                column++;
                                row--;
                                break;
                        }
                    }

                    switch (direction) {
                        case 1:
                            if (columnAccumulator < crossword[0].length) {
                                row = 0;
                                column = columnAccumulator++;
                            } else {
                                row = ++rowAccumulator;
                                column = crossword[0].length - 1;
                            }
                            break;
                        case 2:
                            row = 0;
                            column++;
                            break;
                        case 3:
                            if (columnAccumulator < crossword[0].length) {
                                row = 0;
                                column = crossword[0].length - ++columnAccumulator;
                            } else {
                                row = ++rowAccumulator;
                                column = 0;
                            }
                            break;
                        case 4:
                            row++;
                            column = crossword[0].length - 1;
                            break;
                        case 6:
                            row++;
                            column = 0;
                            break;
                        case 7:
                            if (rowAccumulator < crossword.length - 1) {
                                row = ++rowAccumulator;
                                column = crossword[0].length - 1;
                            } else {
                                row = crossword.length - 1;
                                column = crossword[0].length - ++columnAccumulator;
                            }
                            break;
                        case 8:
                            row = crossword.length - 1;
                            column++;
                            break;
                        case 9:
                            if (rowAccumulator < crossword.length - 1) {
                                row = ++rowAccumulator;
                                column = 0;
                            } else {
                                row = crossword.length - 1;
                                column = columnAccumulator++;
                            }
                            break;
                    }
                }
            }
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
