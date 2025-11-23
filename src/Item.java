public abstract class  Item {

    protected String name;
    protected String description;

    public abstract String examine();
    public abstract boolean use(Player player);

    @Override
    public String toString() {
        return name;
    }

}
