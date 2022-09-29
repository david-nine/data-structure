package senailist;

import java.util.*;

public class ArrayListImpl<T> implements List<T> {

    private T[] instance;
    private boolean resizable;
    private int initialCapacity = DEFAULT_CAPACITY;
    private final static int DEFAULT_CAPACITY = 10;

    public ArrayListImpl() {
        this(DEFAULT_CAPACITY, true);
    }

    public ArrayListImpl(int size) {
        this(size, true);
    }

    public ArrayListImpl(int size, boolean resizable) {
        this.instance = (T[]) new Object[size];
        this.resizable = resizable;
        this.initialCapacity = size;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < this.instance.length; i++) {
            if (this.instance[i] != null) {
                counter++;
            }
        }
        return counter;
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

    public boolean isFull() {
        if (this.size() == this.instance.length && this.resizable == false) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        for (int i = 0; i < this.instance.length; i++) {
            if (this.instance[i] == null) {
                this.instance[i] = t;
                return true;
            }
        }
        if (this.resizable) {
            T[] newInstance = resizeArrayList();
            newInstance[this.instance.length + 1] = t;
            this.instance = newInstance;
            return true;
        }
        return false;
    }

    private T[] resizeArrayList() {
        T[] newInstance = (T[]) new Object[this.instance.length * 2];
        for (int i = 0; i < this.instance.length; i++) {
            newInstance[i] = this.instance[i];
        }
        return newInstance;
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
        this.instance = (T[]) new Object[this.initialCapacity];
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        if ((index - this.size() - 1) < 1) {
            T objectToSubtract = this.instance[index];
            this.instance[index] = element;
            return objectToSubtract;
        }
        throw new IndexOutOfBoundsException(String.format("Index %s out of bounds for length %s", index, this.size()));
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
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
        for (int i = this.instance.length -1 ; i > -1; i--) {
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
