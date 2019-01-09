package com.tgt.testapp.dataoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConventionalInterfaces {

    /**
     *
     * @param predicate test to be applied to each element of the inputList.
     * @param inputList of integers
     *  @return list of elements that passes the predicate.
      */

    public List<Integer> filterFunction(Predicate predicate, List<Integer> inputList) {

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            if (predicate.test(inputList.get(i))) {
                resultList.add(inputList.get(i));
            }
        }
        return resultList;
    }

    /**
     *
     * @param operation to be performed on each element of the inputList.
     * @param inputList is a list of integers.
     * @return list of mapped elements corresponding to the inputList.
     */
    public List<Integer> mapFunction(Function operation, List<Integer> inputList) {

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            resultList.add((Integer) operation.apply(inputList.get(i)));
        }

        return resultList;
    }


    /**
     * accumulate(Function operation, int initial, List<Integer> list)
     *
     * @param operation is a combination function that combines elements in the input-list.
     * @param initial is the value that is the beginning of the combination.
     * @param inputList is the list of integers
     * @return result of combination as a integer value.
     */

    public int accumulateFunction(BiFunction operation, int initial, List<Integer> inputList) {

        int result = initial;
        for (int i = 0; i < inputList.size(); i++) {
            result = (Integer) operation.apply(inputList.get(i), result);
        }
        return result;
    }

    public static void main(String[] args) {
        ConventionalInterfaces conventionalInterfaces = new ConventionalInterfaces();

        int accumulateResult = conventionalInterfaces.accumulateFunction(((x, y) -> (Integer) x + (Integer) y), 1, Arrays.asList(1, 2, 3));
        System.out.println("Accumulated-Result: " + accumulateResult);

        List<Integer> filteredResult = conventionalInterfaces.filterFunction((x -> (Integer) x % 2 == 0), Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Filtered-Result: " + filteredResult);

        List<Integer> mappedResult = conventionalInterfaces.mapFunction(x -> (Integer) x * (Integer) x, Arrays.asList(1, 2, 3, 4));
        System.out.println("Mapped-Result: " + mappedResult);

        // for a list of integers, filter for even elements, and compute the multiplication operation and return the result.
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);
        inputList.add(6);
        inputList.add(7);
        inputList.add(8);

        int combinedResult = conventionalInterfaces.accumulateFunction((x, y) -> ((Integer) x * (Integer) y),
                                                    1,
                                                    conventionalInterfaces.filterFunction((x -> (Integer) x % 2 == 0), inputList));
        System.out.println("Filter + Accumulate: " + combinedResult);

        // filter even elements from a list, then apply cube to each filtered element and add the result.
        int modResult = conventionalInterfaces.accumulateFunction((x, y) -> (Integer) x + (Integer) y, 0,
                conventionalInterfaces.mapFunction(x -> (Integer) x * (Integer) x * (Integer) x,
                conventionalInterfaces.filterFunction(x -> (Integer) x % 2 == 0, inputList)));

        System.out.println("Filter + Map + Accumulate: " + modResult);
    }

}
