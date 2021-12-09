package matcher.sample;

import matcher.ArrayTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class MysteryLibrary implements Sample {

    private final int[] sequence;

    public MysteryLibrary(String filePath) {
        sequence = parse(filePath);
    }

    private int[] parse(String filePath) {
        File file = new File(filePath);
        int[] vector = new int[chrMLength];
        Arrays.fill(vector, INVALID);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //noinspection UnusedAssignment
            String line = br.readLine(); // skip first line
            int counter = 0;
            while ((line = br.readLine()) != null) {
                vector[counter] = extractIndex(line);
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    private Integer extractIndex(String line) {
        if (line.length() < 2) {
            return INVALID;
        }

        String[] splitLine = line.split("\\s+");
        int[] values = ArrayTools.convertToIntArray(splitLine);
        float sum = ArrayTools.getSum(values);
        if (sum < 3) {
            return INVALID;
        }

        int indexOfMax = ArrayTools.argmaxOf1st4(values);
        if (values[indexOfMax] / sum > .75) {
            return indexOfMax;
        }
        return INVALID;
    }

    @Override
    public int[] getChrM() {
        return sequence;
    }
}
