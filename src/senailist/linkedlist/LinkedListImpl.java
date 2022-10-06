package senailist.linkedlist;

public class LinkedListImpl<T> {

    private KnotList<T> first;
    private KnotList<T> last;
    private int counter;

    public LinkedListImpl() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    public int size() {
        return this.counter;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public boolean contains(T obj) {
        KnotList<T> temp = this.first;
        while (temp != null && temp.getObj() != obj) {
            temp = temp.getNext();
        }
        return temp != null && temp.getObj() != null;
    }

    public boolean add(T t) {
        if (isEmpty()) {
            this.first = new KnotList<>(t, null);
            this.last = this.first;
        } else {
            this.last.setNext(new KnotList<>(t, null));
            this.last = this.last.getNext();
        }
        this.counter++;
        return true;
    }

    public void clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    public T get(int index) {
        if (index >= counter || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == counter - 1) {
            return this.last.getObj();
        }

        KnotList<T> temp = this.first;
        for (int i = 0; i < this.size(); i++) {
            if (index == i) {
                return temp.getObj();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {
        if (index > counter && index >= 0) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            this.add(element);
        } else if (index == 0) {
            first = new KnotList<>(element, first);
            counter++;
        } else {
            KnotList<T> temp = this.first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(new KnotList<>(element, temp.getNext()));
            if (index == counter) {
                last = temp.getNext();
            }
            counter++;
        }
    }

    public int indexOf(T obj) {
        int count = 0;

        KnotList<T> temp = this.first;
        while (temp.getNext() != null) {
            if (temp.getObj() == obj) {
                return count;
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }

    public int lastIndexOf(T obj) {
        int count = 0;
        int lastIndex = -1;
        KnotList<T> temp = this.first;
        while (temp.getNext() != null) {
            if (temp.getObj() == obj) {
                lastIndex = count;
            }
            temp = temp.getNext();
            count++;
        }
        return lastIndex;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Empty list");
        } else {
            StringBuilder stringList = new StringBuilder();
            KnotList<T> temp = this.first;
            while (temp != null && temp.getObj() != null) {
                stringList.append(temp.getObj().toString());
                stringList.append(", ");
                temp = temp.getNext();
            }
            System.out.println(stringList.substring(0, stringList.length() - 2) + ".");
        }
    }
}
