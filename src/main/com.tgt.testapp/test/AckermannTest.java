package com.tgt.testapp.test;

import com.tgt.testapp.dataoperations.Ackermann;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AckermannTest {

    @Test
    public void ackermannFunctionTest() {
        int result = Ackermann.ackermannFunction(3, 1);
        assertEquals(result,13);
    }

    @Test(expected = StackOverflowError.class)
    public void test2() {
        int result = Ackermann.ackermannFunction(4 , 2);
    }

}
