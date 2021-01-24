/**
 *CSI 2120 - Comprehensive Assignment 0
 *@author John Sanvictores 300014321
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KnapsackProblem {

    private int capacity, numItems, solSize;
    private int[] selected;
    private Knapsack knapsack;
    private String fileName;
    private KTable table;

    public KnapsackProblem(Knapsack k, String fileName) {

        this.knapsack = k;
        capacity = k.getCapacity();
        numItems = k.size();
        this.fileName = fileName;
        table = new KTable(numItems + 1, capacity + 1);
        System.out.println(k);

    }

    public int dynamicSolve() {

        int[] values = knapsack.getValues();
        int[] weights = knapsack.getWeights();
        ArrayList<Item> items = knapsack.getItems();
        System.out.println(items);

        String[] names = knapsack.getNames();

        // Taken from geeksforgeeks with minor tweaks ---> https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
        for (int i = 0 ; i <= numItems ; ++i) {
            for (int j = 0 ; j <= capacity ; ++j) {

                print("i j " + i + " " + j);

                if (i == 0 || j == 0) { table.set(i, j, new Knapsack()); }

                else if (weights[i - 1] <= j) {

                    Knapsack k = new Knapsack(table.get(i-1,j));
                    System.out.println("weight: " + weights[i]);
                    System.out.println("j: " + j);

                    int a = table.get(i-1,j).sumWeights();
                    int b = values[i-1] + table.get(i-1, j-weights[i-1]).sumWeights();

                    if (a > b) {
                        k.add(items.get(i-1));
                    } else {
                        k.add(items.get(i));
                    }

                    table.set(i,j, k);
                    System.out.println("set: " + k);

                } else {

                    table.set(i, j, table.get(i-1,j));

                }

//                if (i == 0 || j == 0) {
//
//                    table.set(i, j, new Knapsack());
//                    print("\nBase case");
//                    System.out.println(table.get(i,j));
//
//
//                }
//
//                else if (weights[i-1] <= j) {
//
//                    print("\n2nd Case");
//                    table.set(i, j, table.get(i-1,j).max(table.get(i-1,j-weights[i-1]), values[i-1]));
//                    System.out.println(table.get(i,j));
//
//                }
//
//                //table.set(i, j, Math.max(values[i - 1] + table.get(i-1, j-weights[i-1]), table.get(i-1, j)));
//                else {
//
//                    print("\nLast Case");
//                    table.set(i, j, table.get(i-1, j));
//                    System.out.println(table.get(i,j));
//
//                }

            }
        }

        System.out.println("Solution: " +
                            table.get(numItems,capacity));
        return table.get(numItems, capacity).sumWeights();
        // End of copied code
    }

    public int bruteForce() { return bruteForce(capacity, knapsack.getWeights(), knapsack.getValues(), numItems); }

    private int bruteForce(int capacity, int[] weights, int[] values, int numItems) {

        // Taken from geeksforgeeks with minor tweaks ---> https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
        if (numItems == 0 || capacity == 0) { return 0; }

        if (weights[numItems - 1] > capacity) { return bruteForce(capacity, weights, values, numItems - 1); }
        else { return Math.max(values[numItems - 1] + bruteForce(capacity - weights[numItems - 1], weights, values, numItems - 1),
                    bruteForce(capacity, weights, values, numItems - 1)); }
        // End of copied code
    }

    // Method that writes solutions to a .sol file
    public void writeTo() throws IOException {

        FileWriter fw = new FileWriter(fileName.split("[.]")[0].concat(".sol"));
        fw.write(dynamicSolve() + "\n");
        //getSolIndices();

        //for (int i = solSize - 1 ; i >= 0 ; --i) { fw.write(knapsack.getItems().get(selected[i]).getName() + " "); }

        fw.close();

    }

    // Method that gets the array of indices of the solutions
//    private void getSolIndices() {
//
//        int[] values = knapsack.getValues();
//        int[] weights = knapsack.getWeights();
//
//        // Taken from stackexchange with minor tweaks ---> https://stackoverflow.com/questions/45405662/how-to-return-the-weight-and-the-corresponding-index-in-this-knapsack-java-code
//        selected = new int[numItems + 1];
//        int tmp = capacity;
//        solSize = 0;
//
//        for (int i = numItems ; i > 0 ; --i) {
//            if ((tmp - weights[i - 1] >= 0) && (table.get(i, tmp) - table.get(i-1, tmp-weights[i-1]) == values[i - 1])) {
//                selected[solSize++] = i - 1;
//                tmp -= weights[i - 1];
//            }
//        }
//
//        for (int i = solSize - 1 ; i >= 0 ; --i) { System.out.println("Item: " + knapsack.getItems()[selected[i]].getName()); }
//        // End of copied code
//    }

    private void print(String str) { System.out.println(str); }

    ///////////////////////////// Main ////////////////////////////////

    public static void main(String[] args) throws Exception {

        if (args.length != 2) { throw new Exception("Argument length of only 2 is required"); }

        File f = new File(args[0]);
        Scanner s = new Scanner(f);

        int numItems = s.nextInt();
        Item[] items = new Item[numItems];

        for (int i = 0 ; i < numItems ; ++i) {

            Item item = new Item(s.next(), s.nextInt(), s.nextInt());
            items[i] = item;

        }

        Knapsack k = new Knapsack(items, s.nextInt());
        KnapsackProblem kp = new KnapsackProblem(k, args[0]);

        if (args[1].toUpperCase().equals("D")) {

            System.out.println("Dynamic Solution: " + kp.dynamicSolve());
            kp.writeTo();

        } else if (args[1].toUpperCase().equals("F")) {

            System.out.println("Brute Force Solution: " + kp.bruteForce());
            kp.writeTo();

        } else { throw new Exception("Invalid flag: " + args[1] + ". Use 'F' or 'D'."); }

    }

}
