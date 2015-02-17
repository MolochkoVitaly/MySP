package work;

import java.io.*;
import java.util.*;

public class AllJuices {
     private ArrayList<Juice> juices = new ArrayList<Juice>();

    public ArrayList<Juice> getJuices() {
        return juices;
    }

    public void loadAllJuicesFromFile() throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader("juice.in"));
        StringTokenizer st;
        Juice juiceTmp;
        ArrayList<String> fruitsTmp;
        String line = fileReader.readLine();

        while(line != null){
            st = new StringTokenizer(line, " ");
            fruitsTmp = new ArrayList<String>();

            while(st.hasMoreTokens()){
                fruitsTmp.add(st.nextToken());
            }

            juiceTmp = new Juice(fruitsTmp);
            juices.add(juiceTmp);
            line = fileReader.readLine();

        }

        fileReader.close();
    }

    //for first task
    public void getAllComponents() throws FileNotFoundException{
        Set setFruits = new LinkedHashSet<String>();

        for (Juice juice : juices) {
            for (int j = 0; j < juice.getFruits().size(); j++) {
                setFruits.add(juice.getFruits().get(j));
            }
        }

        PrintWriter pw = new PrintWriter("juice1.out");
        for (String setFruit : (Iterable<String>) setFruits) {
            pw.println(setFruit);
        }
        pw.flush();
        pw.close();
    }

    public void clean(ArrayList<Juice> copyJuices, Juice juice){
        copyJuices.remove(juice);
        for (int i = 0; i < copyJuices.size(); i++) {
            if(copyJuices.get(i).getFruits().containsAll(juice.getFruits())){
                Juice tmp = copyJuices.get(i);
                clean(copyJuices, tmp);
            }
        }
    }

    //for third task
    public void getMinimalCount() throws FileNotFoundException{
        ArrayList<Juice> copyJuices = new ArrayList<Juice>();
        copyJuices.addAll(getJuices());

        int counter = 0;
        while(!copyJuices.isEmpty()){
            Juice juice = copyJuices.get(0);
            clean(copyJuices,juice);
            counter++;
        }
        PrintWriter pw = new PrintWriter("juice3.out");
        pw.println(counter);
        pw.close();
    }

    @Override
    public String toString() {
        return juices.toString();
    }
}
