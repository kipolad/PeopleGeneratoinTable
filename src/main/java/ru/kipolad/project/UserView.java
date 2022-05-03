/**
 * Created by Yulya Telysheva
 */
package ru.kipolad.project;

import java.util.Scanner;

public class UserView {

    public static int getNumberOfRows() {
        Scanner console = new Scanner(System.in);
        int count = 0;

        System.out.println("Привет :) С каким количеством строк создать таблицу?");

        while (count == 0) {
            System.out.println("Введи число, от 1 до 30: ");
            String rowsCount = console.nextLine();
            for (int i = 1; i < 31; i++) {
                if (Integer.toString(i).equals(rowsCount)) {
                    count = i;
                    break;
                }
            }
            if (count == 0) System.out.println("Неправильно введены данные :(");
        }
        return count;
    }
}
