import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;


public class KnapsackProblem {

    int bestK, n, L;
    ArrayList<Integer> items;
    int[] bestX, currX;
    HashMap<Pair, Boolean> state;

    public KnapsackProblem(int num) {

        bestK = -1;
        state = new HashMap();
        L = num;
        items = new ArrayList();

    }

    public void dynamicSolve(int currK, int currS) {

        int totalWeight = 0;

        if (currK > bestK) {
            bestK = currK;
            bestX = Arrays.copyOf(currX, n);
        }

    }

    public static void main(String[] args) throws IOException {

        Knapsack k = new Knapsack();
        File f = new File(args[0]);
        Scanner s = new Scanner(f);

        System.out.println(args[0]);
        int numItems = Integer.parseInt(s.next());
        System.out.println(numItems);
        String[][] strArr = new String[numItems][3];

        for (int i = 0 ; i < numItems ; ++i) {

            strArr[i][0] = s.next();
            strArr[i][1] = s.next();
            strArr[i][2] = s.next();

        }

        System.out.println(Arrays.deepToString(strArr));
        KnapsackProblem kp = new KnapsackProblem(numItems);

        if (args[1].equals("F")) {

            kp.dynamicSolve();

        }

    }

}
