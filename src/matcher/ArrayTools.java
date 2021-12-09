package matcher;

import matcher.sample.Sample;

public class ArrayTools {
    public static float getSum(int[] values) {
        float sum = 0;
        for (int val : values) {
            sum += val;
        }
        return sum;
    }

    public static int[] convertToIntArray(String[] splitLine) {
        int[] values = new int[splitLine.length];
        for (int z = 0; z < values.length; z++) {
            values[z] = Integer.parseInt(splitLine[z]);
        }
        return values;
    }

    public static int argmaxOf1st4(int[] values) {
        int indexForMax = 0;
        for (int i = 0; i < 4; i++) {
            if (values[i] > values[indexForMax]) {
                indexForMax = i;
            }
        }
        return indexForMax;
    }

    public static int difference(Sample sample1, Sample sample2) {
        int[] vec1 = sample1.getChrM();
        int[] vec2 = sample2.getChrM();
        int diff = 0;
        for (int z = 0; z < vec1.length; z++) {
            if (vec1[z] > Sample.INVALID && vec2[z] > Sample.INVALID) {
                if (vec1[z] != vec2[z]) {
                    diff++;
                }
            }
        }
        return diff;
    }

    public static int getMin(int[] values) {
        int indexForMin = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < values[indexForMin]) {
                indexForMin = i;
            }
        }
        return values[indexForMin];
    }
}
