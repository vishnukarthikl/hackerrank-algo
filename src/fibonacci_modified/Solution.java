package fibonacci_modified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Integer[] ints = Input.getInts();
        int first = ints[0];
        int second = ints[1];
        int endIndex = ints[2];
        System.out.println(calculateEndTerm(first, second, endIndex));
    }

    private static BigInteger calculateEndTerm(int first, int second, int endIndex) {
        BigInteger[] answers = new BigInteger[endIndex + 2];
        answers[1] = BigInteger.valueOf(first);
        answers[2] = BigInteger.valueOf(second);
        for (int i = 3; i <= endIndex; i++) {

            answers[i] = answers[i - 1].pow(2).add(answers[i - 2]);
        }
        return answers[endIndex];
    }


    private static class Input {

        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static Integer[] getInts() throws IOException {
            String s = reader.readLine();
            String[] split = s.split(" ");
            Integer[] integers = new Integer[split.length];
            for (int i = 0; i < split.length; i++) {
                integers[i] = Integer.valueOf(split[i]);
            }
            return integers;
        }
    }
}
