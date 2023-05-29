package oop;

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
        myList[index] = element;
        listSize++;
        isEmpty = false;
    }

    public void remove(int index) {
        for (int count = index; count < listSize; count ++)
            myList[count] = myList[index + 1];
        listSize--;
        if (listSize == 0) isEmptyIsTrue();
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
}
