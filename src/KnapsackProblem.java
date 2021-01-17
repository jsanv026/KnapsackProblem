import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;


public class KnapsackProblem {

    private int bestK, n, L;
    private int[] bestX, currX;
    private Knapsack knapsack;
    //HashMap<Pair, Boolean> state;

    public KnapsackProblem(Knapsack k) {

        bestK = -1;
        this.knapsack = k;
        //state = new HashMap();
        n = k.getCapacity();
        this.currX = currX;

    }

    public void dynamicSolve(int currK, int currS) {

        int totalWeight = 0;

        return;

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

        if (args[1].equals("D")) { kp.dynamicSolve(0,0); kp.getKnapsack().display(); }
        else if (args[1].equals("F")) { return; }

    }

}
