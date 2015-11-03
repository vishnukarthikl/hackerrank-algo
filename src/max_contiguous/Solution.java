package max_contiguous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        int N = Input.getInt();
        while (N-- > 0) {
            int size = Input.getInt();
            int[] ints = Input.getInts();
            int maxContiguous = findContiguousMaxSubArray(ints);
            int maxNonContiguous = findNonContiguous(ints);
            System.out.printf("%d %d\n", maxContiguous, maxNonContiguous);
        }

    }

    private static int findNonContiguous(int[] ints) {
        if (allNegative(ints)) {
            return max(ints);
        }
        return positiveTotal(ints);
    }

    private static int positiveTotal(int[] ints) {
        return Arrays.stream(ints).filter(value -> value > 0).sum();
    }

    private static int max(int[] ints) {
        return Arrays.stream(ints).max().getAsInt();
    }

    private static boolean allNegative(int[] ints) {
        return Arrays.stream(ints).allMatch(value -> value < 0);
    }

    private static int findContiguousMaxSubArray(int[] ints) {
        int sumSoFar = ints[0];
        int maxSum = sumSoFar;
        for (int i = 1; i < ints.length; i++) {
            sumSoFar = sumSoFar + ints[i];
            if (sumSoFar < 0) {
                sumSoFar = ints[i];
            }
            maxSum = Math.max(maxSum, sumSoFar);
        }
        return maxSum;
    }


    private static class Input {

        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static int[] getInts() throws IOException {
            String s = reader.readLine();
            String[] split = s.split(" ");
            int[] integers = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                integers[i] = Integer.valueOf(split[i]);
            }
            return integers;
        }

        public static Integer getInt() throws IOException {
            String s = reader.readLine().trim();
            return Integer.valueOf(s);

        }
    }
}
