package com.tgt.testapp.dataoperations;

import java.util.Arrays;
import java.util.List;

public class HornerEval {

    /**
     *
     * @param x, the value at which the polynomial has to be computed.
     * @param inputList, the coefficient list starting at a0 to an.
     * @return integer result of computating the polynomial evaluated at x.
     *
     * iterative implementation.
     */
    public int hornerEvalFunction(int x, List<Integer> inputList) {
        int iterativeResult = 0;
        for (int i = 0; i < inputList.size(); i++) {
            iterativeResult += inputList.get(i) * Math.pow (x, i);
        }
        return iterativeResult;
    }

    /**
     *
     * @param x, the value at which the polynomial has to be computed.
     * @param inputList, the coefficient list starting at a0 to an.
     * @return integer result of computing the polynomial evaluated at x.
     *
     * we have used the accumulateFunctionRecur from ConventionalInterfaces to implement
     * recursively.
     */
    public int hornerEvalRecur(int x, List<Integer> inputList) {
        ConventionalInterfaces conventionalInterfaces = new ConventionalInterfaces();
        int result = conventionalInterfaces.accumulateFunctionRecur((t, u) -> (Integer) t + ((Integer) u) * x, 0, inputList);
        return result;
    }

    public static void main(String[] args) {
        HornerEval hornerEval = new HornerEval();
        int hornerEvalResult = hornerEval.hornerEvalFunction(2, Arrays.asList(1, 3, 0, 5, 0, 1));
        System.out.println("evaluation using iteration: "+ hornerEvalResult);

        int hornerEvalRecurResult = hornerEval.hornerEvalRecur(2, Arrays.asList(1, 3, 0, 5, 0, 1));
        System.out.println("evaluation using recursion: " + hornerEvalRecurResult);
    }
}
