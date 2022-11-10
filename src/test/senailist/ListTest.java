package test.senailist;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import senailist.linkedlist.LinkedListImpl;
import senailist.treewitharray.ITreeWithArray;
import senailist.treewitharray.TreeWithArray;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class ListTest {

    public static class LinkedListTest {

        @Test
        public void addTest() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();
            LinkedListImpl<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(obj2);
            linkedList.add(obj3);

            assertEquals(linkedList.get(1), obj2);
        }

        @Test
        public void addToIndexLastIndexTest() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();
            Object otherObj = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(obj2);
            linkedList.add(obj3);
            linkedList.add(3, otherObj);

            assertEquals(linkedList.get(3), otherObj);
        }

        @Test
        public void addToIndexInMiddleIndexTest() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();
            Object otherObj = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(obj2);
            linkedList.add(obj3);
            linkedList.add(1, otherObj);

            assertEquals(linkedList.get(1), otherObj);
            assertEquals(linkedList.get(2), obj2);
        }

        @Test
        public void addToIndexInEmptyList() {
            Object obj = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(0, obj);

            assertEquals(linkedList.get(0), obj);
            assertEquals(linkedList.size(), 1);
        }

        @Test
        public void addToIndexToFirstIndex() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(0, obj2);

            assertEquals(linkedList.get(0), obj2);
            assertEquals(linkedList.get(1), obj1);
            assertEquals(linkedList.size(), 2);
        }

        @Test
        public void indexOfTest() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();
            Object obj4 = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(obj2);
            linkedList.add(obj3);
            linkedList.add(obj4);

            int result = linkedList.indexOf(obj2);
            assertEquals(result, 1);
        }

        @Test
        public void lastIndexOfTest() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();
            Object obj4 = new Object();
            Object obj5 = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(obj2);
            linkedList.add(obj3);
            linkedList.add(obj4);
            linkedList.add(obj2);
            linkedList.add(obj5);

            int result = linkedList.lastIndexOf(obj2);
            assertEquals(result, 4);
        }

        @Test
        public void contains() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(obj2);
            linkedList.add(obj3);

            boolean result = linkedList.contains(obj2);
            assertTrue(result);
        }

        @Test
        public void containsNotContains() {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();
            List<Object> linkedList = new LinkedListImpl<>();
            linkedList.add(obj1);
            linkedList.add(obj2);
            linkedList.add(obj3);

            boolean result = linkedList.contains(new Object());
            assertFalse(result);
        }

        @Test
        public void treeWithArrayTest() {
            ITreeWithArray<Integer> tree = new TreeWithArray<>(2, 4);

            tree.sequentialInsert(7);
            tree.sequentialInsert(5);
            tree.sequentialInsert(11);
            tree.sequentialInsert(2);
            tree.sequentialInsert(null);
            tree.sequentialInsert(10);
            tree.sequentialInsert(10);
            tree.sequentialInsert(17);
            tree.sequentialInsert(1);
            tree.sequentialInsert(3);
            tree.sequentialInsert(9);

            System.out.print(tree);
        }
    }
}