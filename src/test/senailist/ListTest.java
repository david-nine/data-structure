package test.senailist;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import senailist.ArrayListImpl;
import senailist.LinkedListImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class ListTest {

    public static class Constructor {

        @Test
        public void addTest() {
            long timeStart = System.nanoTime();
            int a = 2;
            for (int i = 0; i < 1000000; i++) {
                a*=2;
            }
            System.out.println(System.nanoTime() - timeStart);
            timeStart = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                a = a<<1;
            }
            System.out.println(System.nanoTime() - timeStart);

        }

        @Test
        public void addOutOfDefaultSizeTest() {
            ArrayListImpl<Object> objects = new ArrayListImpl<>();
            for (int i = 0; i < 10; i++) {
                objects.add(new Object());
            }
            Object lastObject = new Object();
            objects.add(lastObject);

            assertEquals(objects.toArray().length, 20);
            assertEquals(objects.toArray()[11], lastObject);
        }

        @Test
        public void lasIndexOfTest() {
            List<Object> objects = new LinkedListImpl<>();
            Object objectToSearch = new Object();
            objects.add(objectToSearch);
            objects.add(new Object());
            objects.add(objectToSearch);
            objects.add(new Object());
            objects.add(new Object());

            assertEquals(objects.lastIndexOf(objectToSearch), 2);
        }

        @Test
        public void remove() {
            List<Object> objects = new LinkedListImpl<>();
            objects.add(new Object());
            objects.add(1L);
            Object object = new Object();
            objects.add(object);
            objects.add(new Object());
            objects.remove(0);

            assertEquals(objects.toArray()[0], 1L);
            assertEquals(objects.size(), 3);
        }

    }

}