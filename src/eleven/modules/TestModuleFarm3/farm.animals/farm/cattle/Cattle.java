package eleven.modules.TestModuleFarm3.farm.animals.farm.cattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cattle {
    private List<Cow> cattleTagNumbers = Arrays.asList(new Cow("C1"), new Cow("C2"), new Cow("C3"));

    public int getTotal() {
        return cattleTagNumbers.size();
    }

    public List<Cow> getCattleTagNumbers() {
        return new ArrayList<>(cattleTagNumbers); // defensive copying
    }
}
