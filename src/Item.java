public abstract class Item {

    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public abstract String examine();
    public abstract boolean use(Player player);

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
