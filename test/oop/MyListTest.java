package oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {
    MyList myList;
    @BeforeEach public void beforeEach(){
        myList = new MyList();
    }
    @Test public void listExistTest(){

        assertNotNull(myList);
    }

    @Test public void myListIsEmptyTest(){

        assertTrue(myList.isEmpty());
    }

    @Test public void addElementToList_isEmptyReturnsFalseTest(){

        myList.add(0, 3);

        assertFalse(myList.isEmpty());
    }

    @Test public void addElement3And2_Remove3And_isEmptyReturnsFalseTest(){
        myList.add(0, 3);
        myList.add(1, 4);

        myList.remove(1);

        assertFalse(myList.isEmpty());
    }
    @Test public void addElement3And4_RemoveAllElements_isEmptyShouldReturnTrueTest(){
        myList.add(0, 3);
        myList.add(1, 4);

        myList.remove(0);
        myList.remove(1);

        assertTrue(myList.isEmpty());
    }

    @Test public void addElementsToListAndGetElementAtIndex2Test(){
        myList.add(0, 3);
        myList.add(1, 4);
        myList.add(2, 5);
        myList.add(3, 5);

        int expectedElement = myList.get(2);

        assertEquals(5, expectedElement);
    }
    @Test public void addElementsToListAndGetElementAtIndex1Test(){
        myList.add(0, 3);
        myList.add(1, 4);
        myList.add(2, 5);
        myList.add(3, 5);

        int expectedElement = myList.get(1);

        assertEquals(4, expectedElement);
    }
    @Test public void sizeOfListTest(){
        myList.add(0, 3);
        myList.add(1, 4);
        myList.add(2, 5);
        myList.add(3, 5);

        assertEquals(4, myList.size());
    }
    @Test public void afterAddElements_clearShouldMakeListEmpty(){
        myList.add(0, 3);
        myList.add(1, 4);
        myList.add(2, 5);
        myList.add(3, 5);

        myList.clear();

        assertTrue(myList.isEmpty());
    }
    @Test public void afterClearingList_getShouldReturn_0_Test(){
        myList.add(0, 3);
        myList.add(1, 4);
        myList.add(2, 5);
        myList.add(3, 5);

        myList.clear();

        assertEquals(0, myList.get(2));
    }



}
