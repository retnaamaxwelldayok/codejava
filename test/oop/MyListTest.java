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

        myList.add(3);

        assertFalse(myList.isEmpty());
    }

    @Test public void addElement3And2_Remove3And_isEmptyReturnsFalseTest(){
        myList.add(3);
        myList.add(4);

        myList.remove(1);

        assertFalse(myList.isEmpty());
    }

    @Test public void addElement3And4_RemoveAllElements_isEmptyShouldReturnTrueTest(){
        myList.add(3);
        myList.add(4);

        myList.remove(0);
        myList.remove(1);

        assertTrue(myList.isEmpty());
    }

    @Test public void throwExceptionIfIndexGivenForRemoveMethodIsOutOfBoundsTest(){
        myList.add(3);
        myList.add(4);
        myList.add(4);

        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> {
            myList.remove(5);
        });
    }

    @Test public void addElementsToListAndGetElementAtIndex2Test(){
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(5);

        int expectedElement = myList.get(2);

        assertEquals(5, expectedElement);
    }

    @Test public void addElementsToListAndGetElementAtIndex1Test(){
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(5);

        int expectedElement = myList.get(1);

        assertEquals(4, expectedElement);
    }

    @Test public void sizeOfListTest(){
        myList.add(3);
        myList.add(14);
        myList.add(5);
        myList.add(5);

        assertEquals(4, myList.size());
    }

    @Test public void afterAddElements_clearShouldMakeListEmpty(){
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(5);

        myList.clear();

        assertTrue(myList.isEmpty());
    }

    @Test public void afterClearingList_getShouldReturn_0_Test(){
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(5);

        myList.clear();

        assertNotNull(myList);
        assertEquals(0, myList.get(2));
    }

    @Test public void overloadedAddMethodThatAddElementGivenAtTheEndOfListTest(){
        myList.add(5);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(8);
        myList.add(3);
        myList.add(4);

        myList.add(20);

        assertEquals(20, myList.get(7));
    }

    @Test public void addElementInTheMiddleOfAListTest(){
        myList.add(5);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(8);
        myList.add(3);

        myList.add(3, 20);

        assertEquals(7, myList.size());
        assertEquals(20, myList.get(3));
        assertEquals(5, myList.get(4));
        assertEquals(8, myList.get(5));
        assertEquals(3, myList.get(6));
    }
    @Test public void methodIndexOfThatReturnsTheIndexOfElementsFirstOccurrenceTest(){
        myList.add(5);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(8);
        myList.add(3);

        int indexOf = myList.indexOf(3);

        assertEquals(1, indexOf);
    }
    @Test public void methodIndexOfThatReturnsTheIndexOfElementsLastOccurrenceTest(){
        myList.add(5);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(8);
        myList.add(3);

        int indexOf = myList.lastIndexOf(3);

        assertEquals(5, myList.lastIndexOf(3));
    }

}
