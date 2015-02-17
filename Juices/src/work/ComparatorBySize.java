package work;

import java.util.Comparator;

/**
 * Created by Виталий on 17.02.2015.
 */
public class ComparatorBySize implements Comparator<Juice> {
    @Override
    public int compare(Juice o1, Juice o2) {
        return o1.getFruits().size() - o2.getFruits().size();
    }
}
