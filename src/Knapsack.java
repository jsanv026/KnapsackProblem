public class Knapsack {

    private Item[] items;
    private int capacity,size;
    private int[] values, weights;

    public Knapsack(Item[] items, int capacity) {

        this.items = items;
        this.capacity = capacity;
        size = items.length;
        values = new int[size];
        weights = new int[size];
        setupArr();

    }

    public void display() {

        System.out.println("----- Capacity: " + capacity + " -----");
        for (int i = 0 ; i < items.length ; ++i) { System.out.println("--> " + items[i].getName() + " " + items[i].getValue() + " " + items[i].getWeight()); }

    }

    public int getCapacity() { return capacity; }
    public Item[] getItems() { return items; }
    public int size() { return size; }
    public int[] getValues() { return values; }
    public int[] getWeights() { return weights; }

    private void setupArr() {
        int i = 0;
        for (Item itm : items) {
            values[i] = itm.getValue();
            weights[i++] = itm.getWeight();
        }

    }

}
