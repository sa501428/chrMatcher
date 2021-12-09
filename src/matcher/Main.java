package matcher;

import matcher.sample.Individual;
import matcher.sample.IndividualVault;
import matcher.sample.MysteryLibrary;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Individual> individuals = (new IndividualVault()).load();
        MysteryLibrary mysteryLibrary = new MysteryLibrary(args[args.length - 1]);

        int[] diffs = new int[individuals.size()];

        for (int i = 0; i < diffs.length; i++) {
            Individual individual = individuals.get(i);
            diffs[i] = ArrayTools.difference(individual, mysteryLibrary);
        }

        int minDist = ArrayTools.getMin(diffs);
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= minDist) {
                Individual individual = individuals.get(i);
                System.out.println("Dist: " + diffs[i] + "  Genotype: " + individual.getName());
            }
        }
    }
}
