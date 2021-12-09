package matcher.sample;

public class Individual implements Sample {

    private final String name;
    private final int[] sequence;

    public Individual(String nameAndID) {
        String[] splitArray = nameAndID.split("\t");
        name = splitArray[0];
        sequence = parseIntSequence(splitArray[1]);
    }

    private int[] parseIntSequence(String str) {
        char[] chars = str.toCharArray();
        int[] seq = new int[chrMLength];
        for (int i = 0, n = chars.length; i < n; i++) {
            try {
                seq[i] = Integer.parseInt("" + chars[i]);
            } catch (Exception e) {
                seq[i] = INVALID;
            }
        }
        return seq;
    }

    @Override
    public int[] getChrM() {
        return sequence;
    }

    public String getName() {
        return name;
    }
}
