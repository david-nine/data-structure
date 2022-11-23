package senailist.treewitharray;

public class TreeWithArray<T> implements ITreeWithArray<T> {

    private T[] array;
    private int h;
    private int g;
    int counter = 0;

    public TreeWithArray(int g, int h) {
        this.g = g;
        this.h = h;
        this.array = (T[]) new Object[this.maxQuantityChild()];
    }

    private int maxQuantityChild() {
        int quantity = 0;
        for (int i = 0; i <= h; i++) {
            quantity += Math.pow(g, i);
        }
        return quantity;
    }

    @Override
    public boolean sequentialInsert(T obj) {
        if (!this.isFull()) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = obj;
                    this.counter++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean insertWithChild(T obj, int parent) {
        return false;
    }

    @Override
    public boolean isFull() {
        return counter == this.maxQuantityChild();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean checkIfBelongs(T obj) {
        return false;
    }

    @Override
    public int checkParentPosition(T obj) {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        int level = 8;
        double elementsInLine = Math.pow(g, 0);
        for (int i = 0; i < this.maxQuantityChild(); i++) {
            if (i == elementsInLine) {
                elementsInLine = Math.pow(g, i);
            }
            result.append(array[i] + "\t");
            if (elementsInLine == i + 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
