package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int[] array = {1, 3, 9, 27, 81, 243, 729, 2187};
        String resultStr = number + " =";
        for (int i = 0; i < 6560; i++){
            String tryString = String.format("%08d", Integer.parseInt(Integer.toString(i, 3)));
            int sum = 0;
            for (int j = 0; j < 8; j++){
                if ("0".equals(String.valueOf(tryString.charAt(j)))){
                    sum += array[j];
                } else if ("1".equals(String.valueOf(tryString.charAt(j)))) {

                } else if ("2".equals(String.valueOf(tryString.charAt(j)))) {
                    sum -= array[j];
                }
            }
            if (sum == number) {
                for (int j = 0; j < 8; j++){
                    if ("0".equals(String.valueOf(tryString.charAt(j)))) {
                        resultStr = resultStr + " + " + array[j];
                    }else if ("1".equals(String.valueOf(tryString.charAt(j)))) {

                    }else if ("2".equals(String.valueOf(tryString.charAt(j)))) {
                        resultStr = resultStr + " - " + array[j];
                    }
                }
                break;
            }
        }
        System.out.println(resultStr);
    }
}