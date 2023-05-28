package oop;

public class MyStack {
    private boolean isEmpty = true;
    private int top;
    private String[] stack;
    private int stackSize;
    private boolean isFull = false;

    public MyStack(int stackSize) {
        this.stackSize = stackSize;
        stack = new String[stackSize];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void push(String elament) {
        if (top < (stack.length)){
            stack[top++] = elament;
        }
        isEmpty = false;
    }

    public void pop() {
        top--;
        boolean stackIsEmpty = top == 0;
        if (stackIsEmpty) isEmpty = true;
    }

    public String peak() {
        return stack[--top];
    }

    public boolean isFull() {
        if(top == stackSize) isFull = true;
        return isFull;
    }
}