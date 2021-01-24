/**
 *CSI 2120 - Comprehensive Assignment 1
 *@author John Sanvictores 300014321
 */

public class KTable {

    private int[][] table;

    public KTable(int x, int y) { table = new int[x][y]; }

    public int get(int x, int y) { return table[x][y]; }
    public void set(int x, int y, int value) { table[x][y] = value; }


}
