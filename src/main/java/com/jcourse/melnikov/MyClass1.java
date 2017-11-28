package com.jcourse.melnikov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyClass1 {
    static Messages messages = new Messages();
    static boolean isWin = false;

    public static void main(String[] args) {
        int number = (int) (1 + Math.random()*99); //Генерация угадываемого числа
        System.out.println(messages.mesHello);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int attempt = 1;
            while (!isWin && (attempt <= 8)) {
                System.out.println(messages.mesTryIt+attempt);
                int myNumber = Integer.parseInt(reader.readLine());
                guessingGame(number, myNumber);
                attempt++;
            }
            reader.close();
        } catch (NumberFormatException e) {
            System.out.println(messages.mesError);
        } catch (IOException e) {
        }

        if (!isWin) {
            System.out.println(messages.mesLose + number);
        }
    }

    static void guessingGame(int number, int myNumber){
        if (number == myNumber) {
            System.out.println(messages.mesWin);
            isWin = true;
        }
        if (number > myNumber) { System.out.println(messages.mesMore); }
        if (number < myNumber) { System.out.println(messages.mesLess); }
    }
}
