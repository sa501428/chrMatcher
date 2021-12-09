package matcher.sample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IndividualVault {


    public List<Individual> load() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("vault.chrM");
        Objects.requireNonNull(is);
        List<Individual> individuals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            for (String line; (line = br.readLine()) != null; ) {
                individuals.add(new Individual(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return individuals;
    }
}
