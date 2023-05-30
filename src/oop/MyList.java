package oop;

import java.util.Arrays;

public class MyList {

    private final int DEFAULT_LIST_SIZE = 10;
    private boolean isEmpty = true;
    private int listSize;
    private int[] myList = new int[DEFAULT_LIST_SIZE];

    public boolean isEmpty() {
        boolean noElementsInList = (listSize == 0);
        if (noElementsInList) isEmpty = true;
        return isEmpty;
    }

    public void add(int index, int element) {
        validateIndex(index);
        boolean indexEqualsTopOfList = listSize == index;
        if(indexEqualsTopOfList) {
            doubleMyListSizeAndAddElement(element);
        } else { insertElementAtGivenIndex(index, element);}
        listSize++;
        isEmpty = false;
    }

    public void add(int element) {
        boolean indexEqualsTopOfList = listSize == myList.length;
        if(indexEqualsTopOfList) doubleMyListSizeAndAddElement(element);
        myList[listSize] = element;
        listSize++;
        isEmpty = false;
    }

    private void isEmptyIsTrue() {
        isEmpty = true;
    }

    public int get(int index) {
        return myList[index];
    }

    public int size() {
        return listSize;
    }

    public void clear() {
        for (int index = 0; index < listSize; index++)
            myList[index] = 0;
        listSize = 0;
    }

    private void insertElementAtGivenIndex(int index, int element) {
        int[] myListCopy = new int[DEFAULT_LIST_SIZE];
        int counter2 = 0;
        for (int counter = 0; counter < listSize + 1; counter++){
            if (counter == index){
                myListCopy[counter2] = element;
                counter2++;
                myListCopy[counter2] = myList[counter];
            }
            myListCopy[counter2] = myList[counter];
            counter2++;
        }
        System.arraycopy(myListCopy, 0, myList, 0, (listSize + 1));
    }

    private void doubleMyListSizeAndAddElement(int element) {
        int[] myListCopy = new int[listSize * 2];
        System.arraycopy(myList, 0, myListCopy, 0, listSize);
        myListCopy[listSize] = element;
        myList = new int[listSize * 2];
        System.arraycopy(myListCopy, 0, myList, 0, ++listSize);
    }

    private void validateIndex(int index) {
        boolean invalidIndex = index < 0 || index > listSize;
        if (invalidIndex) throw new ArrayIndexOutOfBoundsException(" Index "+ index +" is not af bound for List");
    }

    public void remove(int index) {
        validateIndex(index);
        for (int count = index; count < listSize; count ++)
            myList[count] = myList[index + 1];
        listSize--;
        myList[listSize] = 0;
        if (listSize == 0) isEmptyIsTrue();
    }

    public int indexOf(int element) {
        int elmentFirstIndex = -1;
        int index = 0;
        for (; index < listSize; index++)
            if (myList[index] == element) {
                elmentFirstIndex = index;
                break;
            }
        return elmentFirstIndex;
    }

    public int lastIndexOf(int element) {
        int elmentLastIndex = -1;
        int index = 0;
        int elementLastIndex = 0;
        for (; index < listSize; index++)
            if (myList[index] == element) elementLastIndex = index;
        return elementLastIndex;
    }
}

