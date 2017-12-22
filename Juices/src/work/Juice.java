package work;

import java.util.ArrayList;
import java.util.Collections;


public class Juice {
    private ArrayList<String> fruits = new ArrayList<String>();
    private ArrayList<String> fruits2 = new ArrayList<String>();
    private ArrayList<String> fruits3 = new ArrayList<String>();
    private ArrayList<String> fruits4 = new ArrayList<String>();


    public Juice(ArrayList<String> fruit) {
        this.fruits = fruit;
    }

    public void sortFruits(){
        Collections.sort(fruits, new ComparatorForFruits());
    }

    public ArrayList<String> getFruits() {
        return fruits;
    }

    @Override
    public String toString() {
        return "Juice{" +
                "fruits=" + fruits +
                '}';
    }
}
