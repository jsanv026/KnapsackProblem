public class Knapsack {

    private Item[] items;
    private int capacity;

    public Knapsack(Item[] items, int capacity) {

        this.items = items;
        this.capacity = capacity;

    }

    public void display() {

        System.out.println("----- Capacity: " + capacity + " -----");
        for (int i = 0 ; i < items.length ; ++i) { System.out.println("--> " + items[i].getName() + " " + items[i].getValue() + " " + items[i].getWeight()); }

    }

    public int getCapacity() { return capacity; }
    public Item[] getItems() { return items; }

}
