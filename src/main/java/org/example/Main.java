package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {

        TestArraysGenerator.testArrayGeneration();

        try {
            FileReader fileReader = new FileReader("testArrays.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null){
                String [] string = line.split(" ");
                int [] array = new int[string.length];
                for (int i = 0; i < string.length; i++) {
                    array[i] = Integer.parseInt(string[i]);
                }
                double start = System.currentTimeMillis();
                HeapSort object = new HeapSort();
                int a = object.sort(array);

                double end = System.currentTimeMillis();
                System.out.println(string.length + " элементов : " + (end - start) + " миллисекунд " + ", итераций:" + a );
                //System.out.print(string.length + " ");
                //System.out.print(end-start + " ");
                //System.out.println(a + " ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}