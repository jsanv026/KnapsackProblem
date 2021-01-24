/**
 *CSI 2120 - Comprehensive Assignment 0
 *@author John Sanvictores 300014321
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {

    private ArrayList<Item> items;
    private int capacity, size;
    private int[] values, weights;
    private String names[];

    public Knapsack() {

        capacity = 0;
        size = 0;
        setupArr();

    }

    public Knapsack(Knapsack k) {

        this.capacity = k.getCapacity() + 1;
        size = k.getItems().size();
        setupArr();

    }

    public Knapsack(Item[] items, int capacity) {

        this.items = new ArrayList<>(Arrays.asList(items));
        this.capacity = capacity;
        size = items.length;
        setupArr();

    }

    public String toString() {

        if (items == null || values == null || weights == null) return "Empty";
        System.out.println("\n----- Capacity: " + capacity + " -----");
        System.out.println(" Name | Value | Weight \n");
        for (int i = 0 ; i < items.size() ; ++i) { System.out.println("--> " + items.get(i).getName() + "  " + items.get(i).getValue() + "  " + items.get(i).getWeight()); }
        System.out.println("\n--------------------");
        return "";

    }

    // Getters
    public int getCapacity() { return capacity; }
    public ArrayList getItems() { return items; }
    public int size() { return size; }
    public int[] getValues() { return values; }
    public String[] getNames() { return names; }
    public int[] getWeights() { return weights; }

    public void add(Item i) { items.add(i); size++; }

    public int sumWeights() {

        int sum = 0;
        if (weights == null) { return 0; }
        for (int w : weights) { sum += w; }
        return sum;

    }

    // Method to create value and weights array from Item[]
    private void setupArr() {
        int i = 0;
        values = new int[size];
        weights = new int[size];
        names = new String[size];
        if (items == null) {

            items = new ArrayList<Item>(capacity);

        }
        for (Item itm : items) {
            values[i] = itm.getValue();
            names[i] = itm.getName();
            weights[i++] = itm.getWeight();
        }

    }

}
