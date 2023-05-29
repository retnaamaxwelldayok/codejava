package oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    MyStack stack;
    @BeforeEach
    public void beforeEach(){
        stack = new MyStack(5);
    }

    @Test
    public void stackExistTest(){
        assertNotNull(stack);
    }

    @Test public void newStackIsEmpty(){
        MyStack stack = new MyStack(5);
        assertTrue(stack.isEmpty());
    }
    @Test public void pushXStackIsNotEmptyTest(){
        MyStack stack = new MyStack(5);
        stack.push("Retnaa");
        assertFalse(stack.isEmpty());
    }
    @Test public void pushX_Pop_AndStackShouldBeEmpty(){
        stack.push("retnaa");
        stack.pop();

        assertTrue(stack.isEmpty());
    }
    @Test public void pushXYZ_PopXY_StackShouldNotBeEmpty(){
        stack.push("Retnaa");
        stack.push("Oyi");
        stack.push("Jay");

        stack.pop();
        stack.pop();

        assertFalse(stack.isEmpty());
    }
    @Test public void pushX_PeakStack_AndToGetX(){
        stack.push("ret");

        String expectedStackElement = stack.peak();

        assertEquals("ret",expectedStackElement );
    }
    @Test public void pushXYZ_PopZ_AndPeakToGetY(){
        stack.push("Retnaa");
        stack.push("Oyi");
        stack.push("Jay");

        stack.pop();

        assertEquals("Oyi", stack.peak());
    }
    @Test public void alertStackIsFullTest(){
        stack.push("Retnaa");
        stack.push("Oyi");
        stack.push("Jay");
        stack.push("Jay");
        stack.push("Snap");

        stack.push("Sky");

        assertEquals("Snap", stack.peak());

    }
    @Test public void pushABXYZ_StackIsFullTest(){
        stack.push("Retnaa");
        stack.push("Oyi");
        stack.push("Jay");
        stack.push("Jay");
        stack.push("Snap");

        assertTrue(stack.isFull());
    }
    @Test public void pushX_StackShouldBeEmptyTest(){
        stack.push("Retnaa");

        assertFalse(stack.isFull());
    }

}
