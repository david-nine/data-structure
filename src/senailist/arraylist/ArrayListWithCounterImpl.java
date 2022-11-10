package senailist.arraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListWithCounterImpl<T> implements List<T> {

    private T[] instance;
    private boolean resizable;
    private int initialCapacity = DEFAULT_CAPACITY;
    private final static int DEFAULT_CAPACITY = 10;
    private int counter = 0;

    public ArrayListWithCounterImpl() {
        this(DEFAULT_CAPACITY, true);
    }

    public ArrayListWithCounterImpl(int size) {
        this(size, true);
    }

    public ArrayListWithCounterImpl(int size, boolean resizable) {
        this.instance = (T[]) new Object[size];
        this.resizable = resizable;
        this.initialCapacity = size;
    }

    public boolean isFull() {
        return this.counter == this.instance.length && !this.resizable;
    }

    @Override
    public int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object compare) {
        for (T object : this.instance) {
            if (object == compare) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return this.instance;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        this.instance[this.counter] = t;
        this.counter++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        if (this.resizable) {
            this.instance = (T[]) new Object[this.initialCapacity];
        }
        this.counter = 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        if ((index - this.counter) < 1) {
            T objectToSubtract = this.instance[index];
            this.instance[index] = element;
            if (index == this.counter + 1) {
                this.counter++;
            }
            return objectToSubtract;
        }
        throw new IndexOutOfBoundsException(String.format("Index %s out of bounds for length %s", index, this.size()));
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        if (index <= this.counter) {
            T itemToRemove = this.instance[index];
            for (int i = 0; i <= this.counter; i++) {
                this.instance[i] = this.instance[i+1];
            }
            this.instance[this.counter] = null;
            this.counter--;
            return itemToRemove;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object compare) {
        for (int i = 0; i < this.instance.length; i++) {
            if (this.instance[i] == compare) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object compare) {
        for (int i = this.counter; i > -1; i--) {
            if (this.instance[i] == compare) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
