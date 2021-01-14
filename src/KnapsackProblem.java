import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class KnapsackProblem {



    public static void main(String[] args) throws IOException {

        Knapsack k = new Knapsack();
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        System.out.println(args[0]);
        int numItems = Integer.parseInt(br.readLine().replaceAll("\\s", ""));

        System.out.println(numItems);
        String[][] tmp = new String[numItems][3];

        for (int i = 0 ; i < numItems ; ++i) {

            System.out.println(i);

            String curLine = br.readLine();

            for (int j = 0 ; j < curLine.length() ; ++j) {

                int cnt = 0;
                if (curLine.charAt(i) != ' ') {

                    tmp[i][cnt] = tmp[i][cnt] + curLine.charAt(i);

                } else ++cnt; System.out.println(Arrays.deepToString(tmp));

            }


        }

        int capacity = br.read();

        if (args[1].equals("F")) {

            System.out.println("TRUE");

        }

    }

}
