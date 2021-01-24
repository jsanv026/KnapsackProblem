/**
 *CSI 2120 - Comprehensive Assignment 0
 *@author John Sanvictores 300014321
 */

public class KTable {

    private Knapsack[][] table;

    public KTable(int x, int y) { table = new Knapsack[x][y]; }

    public Knapsack get(int x, int y) { return table[x][y]; }
    public void set(int x, int y, Knapsack value) { table[x][y] = value; }


}
