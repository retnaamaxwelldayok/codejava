package oop;

public class MyStack {
    private boolean isEmpty = true;
    private int counter;
    private String[] stack;

    public MyStack(int i) {
        stack = new String[i];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void push(String retnaa) {
        if (counter < (stack.length)){
            stack[counter] = retnaa;
            counter++;
        }
        isEmpty = false;
    }

    public void pop() {
        counter--;
        boolean stackIsEmpty = counter == 0;
        if (stackIsEmpty) isEmpty = true;
    }

    public String peak() {

        return stack[counter - 1];
    }
}