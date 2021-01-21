public class Item {

    private String name;
    private int weight, value;

    public Item(String name, int value, int weight) {

        this.name = name;
        this.value = value;
        this.weight = weight;

    }

    // Getters
    public String getName() { return name; }
    public int getValue() { return value; }
    public int getWeight() { return weight; }

}
