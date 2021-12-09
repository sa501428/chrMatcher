package matcher.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IndividualVault {


    public static List<Individual> load() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("chrM_vault.txt")).getFile());
        List<Individual> individuals = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                individuals.add(new Individual(line));
            }
            // line is not visible here.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return individuals;
    }
}
