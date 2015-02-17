package work;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Виталий on 11.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        try{
            AllJuices allJuices = new AllJuices();
            allJuices.loadAllJuicesFromFile();
            allJuices.getAllComponents();
            Thread sortThread = new Thread(new ThreadForSort(allJuices));
            sortThread.start();
            allJuices.getMinimalCount();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found \n");
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
