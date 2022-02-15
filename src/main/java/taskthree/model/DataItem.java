package taskthree.model;

public abstract class DataItem {
    private String itemKey;

    public DataItem(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemKey() {
        return itemKey;
    }

    public abstract int getDiff();

}
