package gusev.java23.j1_04.task3;

import java.util.Scanner;

public class InputCheck {
    public static int inputCheck(String firstMessage) {
        System.out.print(firstMessage);
        Scanner sc = new Scanner(System.in);
        int inputValue = 0;
        while (true) {
            String input = sc.next();
            try {
                inputValue = Integer.parseInt(input);
                if (inputValue >= 0)
                    break;
                else
                    throw (new NumberFormatException());
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            }
        }
        sc.close();
        return inputValue;
    }
}
