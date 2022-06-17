package com.company.pz2_3;

import java.util.Random;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {


        var c = sort(MyMain::bubbleSort, generateAnArray());
        printAnArray(c);
        System.out.println("Find");
        System.out.println(find(MyMain::binarySearch, promptTheUserToEnterADigit("Get name element:"), c));
        System.out.println("First index");
        System.out.println(firstIndexOf(MyMain::binarySearch, promptTheUserToEnterADigit("Get name element:"), c));


    }

    public static int[] generateAnArray() {

        int len = promptTheUserToEnterADigit("Enter len:");
        int min = promptTheUserToEnterADigit("Enter min:");
        int max = promptTheUserToEnterADigit("Enter max:");

        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) + 1) + min;
        }
        printAnArray(arr);
        return arr;
    }


    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;
            swap(arr, min, i);

        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {

        boolean isSort = true;
        for (int i = 0; i < arr.length; i++) {
            isSort = false;
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    isSort = true;
                }
            }
            if (!isSort) {
                break;
            }
        }
        return arr;
    }

    public static int binarySearch(int searchFor, int[] arr) {
        int name = searchFor;
        int mid;
        int res = -1;
        int l = 0;
        int r = arr.length;
        while (true) {
            mid = l + ((r - l) / 2);
            if (arr[mid] == name) {

                res = mid;
                break;
            } else {
                if (arr[mid] > name) {
                    r = mid;

                } else if (arr[mid] < name) {
                    l = mid;
                }
            }

        }
        return res;
    }

    public static int promptTheUserToEnterADigit(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    public static int[] sort(Sortable sortable, int[] arr) {
        return sortable.sort(arr);
    }

    public static int find(Findable findable, int searchFor, int[] array) {
        return findable.find(searchFor, array);
    }

    public static int firstIndexOf(Findable findable, int searchFor, int[] array) {
        var value = findable.find(searchFor, array);
        while (true) {
            if (array[value] != array[value - 1]) {
                return value;
            } else if (value - 1 == 0) {
               return  0 ;
            }

            value--;
        }
    }


    public static void printAnArray(int[] arr) {
        String s = "";
        for (int i : arr
        ) {
            s += " " + i;
        }
        System.out.println(s);
    }


    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }


}
