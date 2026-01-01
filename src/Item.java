public abstract class Item {

    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    //abstract method(s)
    public abstract boolean use(Player player);

    // Getters
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
