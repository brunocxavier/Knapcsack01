package model;

public class Instance {
    int numberOfItems;
    int capacity;
    short[] weights;
    short[] values;

    public Instance(int numberOfItems, int capacity, short[] weights, short[] values) {
        this.numberOfItems = numberOfItems;
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public short[] getWeights() {
        return weights;
    }

    public void setWeights(short[] weights) {
        this.weights = weights;
    }

    public short[] getValues() {
        return values;
    }

    public void setValues(short[] values) {
        this.values = values;
    }

    public Instance() {
    }
}
