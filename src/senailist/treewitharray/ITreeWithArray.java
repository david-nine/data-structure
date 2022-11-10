package senailist.treewitharray;

public interface ITreeWithArray<T> {

    boolean sequentialInsert(T obj);

    boolean insertWithChild(T obj, int parent);

    boolean isFull();

    boolean isEmpty();

    void clear();

    boolean checkIfBelongs(T obj);

    int checkParentPosition(T obj);

    String toString();

}
