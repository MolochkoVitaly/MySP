package work;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Виталий on 17.02.2015.
 */
public class ThreadForSort implements Runnable {
    private AllJuices allJuices;

    public ThreadForSort(AllJuices allJuices) {
        this.allJuices = allJuices;
    }

    @Override
    public void run() {
        Set setFruits = new LinkedHashSet<String>();

        for (Juice juice : allJuices.getJuices()) {
            for (int j = 0; j < juice.getFruits().size(); j++)
                setFruits.add(juice.getFruits().get(j));
        }

        Iterator iterator = setFruits.iterator();
        ArrayList<String> listFruits = new ArrayList<String>();
        while(iterator.hasNext()){
            listFruits.add((String) iterator.next());
        }

        Collections.sort(listFruits, new ComparatorForFruits());
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("juice2.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String listFruit : listFruits) {
            pw.println(listFruit);
        }
        pw.flush();
        pw.close();
    }
}
