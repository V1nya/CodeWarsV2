package com.company.pz3_5.z_2;

import java.util.LinkedList;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        int n = promptTheUserToEnterADigit("Enter n:");
        int m = promptTheUserToEnterADigit("Enter m:");
        LinkedList<Integer> list = getList(n);

        int i = 0;
        int counter = 1;
        while (list.size() != 1) {
            if (m == counter) {
                list.remove(i);
                counter = 0;
                i--;
            }
            if (list.size() - 1 > i) {
                i++;
            } else {
                i = 0;
            }
            counter++;

        }
        System.out.println(list.get(0));

    }

    public static int promptTheUserToEnterADigit(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    public static LinkedList<Integer> getList(int count) {
        LinkedList<Integer> list = new LinkedList<>();
        int i;
        for (i = 0; i < count; i++) {
            list.add(i);
        }
        return list;
    }
}
