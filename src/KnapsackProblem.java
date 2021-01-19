import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class KnapsackProblem {

    private int capacity, numItems;
    private Knapsack knapsack;

    public KnapsackProblem(Knapsack k) {

        this.knapsack = k;
        capacity = k.getCapacity();
        numItems = k.size();

    }

    public int dynamicSolve() {

        int[] values = knapsack.getValues();
        int[] weights = knapsack.getWeights();
        KTable table = new KTable(numItems + 1, capacity + 1);
        StringBuilder sb = new StringBuilder();

        // Taken from geeksforgeeks.org with minor tweaks ---> https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
        for (int i = 0 ; i <= numItems ; i++) {
            System.out.println("i: " + i);
            for (int j = 0 ; j <= capacity ; j++) {

                if (i == 0 || j == 0) { table.get()[i][j] = 0; }
                else if (weights[i - 1] <= j) { table.get()[i][j] = Math.max(values[i - 1] + table.get()[i - 1][j - weights[i - 1]], table.get()[i - 1][j]); }
                else { table.get()[i][j] = table.get()[i - 1][j]; }

            }
        }

        int[] selected = new int[numItems + 1];
        int tmp = capacity;
        int j = 0;
        for (int i = numItems ; i > 0 ; --i){
            if ((tmp - weights[i - 1] >= 0) && (table.get()[i][tmp] - table.get()[i - 1][tmp - weights[i - 1]] == values[i - 1])) {
                selected[j++] = i - 1;
                tmp -= weights[i - 1];
            }
        }

        for (int i = j - 1 ; i >= 0 ; --i) { System.out.println("Item: " + knapsack.getItems()[selected[i]].getName()); }

        return table.get()[numItems][capacity];

    }

    public int bruteForce() {

        return 0;
    }

    public Knapsack getKnapsack() { return knapsack; }

    ///////////////////////////// Main ////////////////////////////////

    public static void main(String[] args) throws IOException {

        File f = new File(args[0]);
        Scanner s = new Scanner(f);

        int numItems = Integer.parseInt(s.next());
        Item[] items = new Item[numItems];

        for (int i = 0 ; i < numItems ; ++i) {

            Item item = new Item(s.next(), s.nextInt(), s.nextInt());
            items[i] = item;

        }

        Knapsack k = new Knapsack(items, s.nextInt());
        KnapsackProblem kp = new KnapsackProblem(k);
        kp.getKnapsack().display();

        if (args[1].equals("D")) {

            System.out.println("Dynamic Solution: " + kp.dynamicSolve());
        }
        else if (args[1].equals("F")) { return; }

    }

}
