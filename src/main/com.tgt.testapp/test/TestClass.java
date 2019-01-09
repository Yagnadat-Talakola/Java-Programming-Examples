package com.tgt.testapp.test;

import com.tgt.testapp.dataoperations.Ackermann;
import com.tgt.testapp.dataoperations.Subsets;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void ackermannFunctionTest() {
        int result = Ackermann.ackermannFunction(3, 1);
        assertEquals(result,13);
    }

    @Test(expected = StackOverflowError.class)
    public void test2() {
        int result = Ackermann.ackermannFunction(4 , 2);
    }

    @Test
    public void subsetTest() {
        List<Integer> inputList = Arrays.asList(1, 2);
        List<List<Integer>> result = new Subsets().splitList(inputList);
        System.out.println(result);
        assertEquals(result,
                    Arrays.asList(Arrays.asList(), Arrays.asList(1), Arrays.asList(2), Arrays.asList(2, 1)));
    }

}
