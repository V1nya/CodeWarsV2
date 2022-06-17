package com.company.pz3_5.z1;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] first = {4, 3, 3};
        int[] second = {2, 2, 7, 5, 3, 3, 6, 7};
        var in = findSumOfArrays(first, second);

        Arrays.stream(in).forEach(System.out::print);
    }


    static int[] findSumOfArrays(int[] first, int[] second) {

        Stack<Integer> end = new Stack<>();
        int minLen;
        int remainder = -1;
        int i;

        if (first.length >= second.length) {
            minLen = second.length;
        } else {
            minLen = first.length;
        }


        for (i = 0; i < minLen; i++) {
            int number = first[first.length - 1 - i] + second[second.length - 1 - i];
            if (remainder != -1) {
                number += remainder;
                remainder = -1;
            }
            if (number < 10) {
                end.push(number);
            } else {
                remainder = number / 10;
                end.push(number - (remainder * 10));

            }
        }


        if (first.length != minLen) {
            for (i = first.length - minLen - 1; i >= 0; i--) {
                if (remainder != -1) {
                    end.push(first[i] + remainder);
                    remainder = -1;
                } else {
                    end.push(first[i]);
                }
            }
        } else {
            for (i = second.length - minLen - 1; i >= 0; i--) {
                if (remainder != -1) {
                    end.push(second[i] + remainder);
                    remainder = -1;
                } else {
                    end.push(second[i]);
                }
            }
        }

        int[] ret = new int[end.size()];

        for (i = 0; i < ret.length; i++) {
            ret[i] = end.pop();
        }
        return ret;
    }

}
