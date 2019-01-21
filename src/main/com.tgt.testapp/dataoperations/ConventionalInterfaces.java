package com.tgt.testapp.dataoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConventionalInterfaces {

    /**
     * @param predicate test to be applied to each element of the inputList.
     * @param inputList of integers
     * @return list of elements that passes the predicate.
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
     * @param predicate test to be applied to each element of the inputList.
     * @param inputList of integers
     * @return list of elements that pass the predicate.
     * <p>
     * a recursive implementation.
     */
    public List<Integer> filterRecur(Predicate predicate, List<Integer> inputList) {

        List<Integer> filteredList = new ArrayList<>();
        if (inputList.size() == 0) {
            return filteredList;
        } else {
            if (predicate.test(inputList.get(0))) {
                filteredList.add(inputList.get(0));
            }
            filteredList.addAll(filterRecur(predicate, inputList.subList(1, inputList.size())));
        }
        return filteredList;
    }

    /**
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
     * @param operation to be performed on each element of the inputList
     * @param inputList is a list of integers.
     * @return list of mapped elements corresponding to the inputList.
     * <p>
     * used recursion to achieve the objective.
     */

    public List<Integer> mapRecur(Function operation, List<Integer> inputList) {
        List<Integer> mappedResult = new ArrayList<>();

        if (inputList.size() == 0) {
            return mappedResult;
        } else {
            mappedResult.add(((Integer) operation.apply(inputList.get(0))));
            mappedResult.addAll(mapRecur(operation, inputList.subList(1, inputList.size())));
        }
        return mappedResult;
    }

    /**
     * accumulate(Function operation, int initial, List<Integer> list)
     *
     * @param operation is a combination function that combines elements in the input-list.
     * @param initial   is the value that is the beginning of the combination.
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

    /**
     * @param operation, the combination function that combines the elements in the inputList.
     * @param initial    is the value that is the beginning of the combination.
     * @param inputList  is the list of integers.
     * @return result of combination as a integer value.
     * <p>
     * performed accumulation by recursion, adjusting the inputList for every call.
     */
    public int accumulateFunctionRecur(BiFunction operation, int initial, List<Integer> inputList) {

        int result;
        if (inputList.size() == 0) {
            return initial;
        }
        result = (Integer) operation.apply(inputList.get(0), accumulateFunctionRecur(operation, initial, inputList.subList(1, inputList.size())));
        return result;
    }

    public static void main(String[] args) {
        ConventionalInterfaces conventionalInterfaces = new ConventionalInterfaces();

        int accumulateResult = conventionalInterfaces.accumulateFunction(((x, y) -> (Integer) x + (Integer) y), 1, Arrays.asList(1, 2, 3));
        System.out.println("Accumulated-Result: " + accumulateResult);

        int accumulateResultRecur = conventionalInterfaces.accumulateFunctionRecur((x, y) -> (Integer) x + (Integer) y, 0, Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Accumulate using recursion: " + accumulateResultRecur);

        List<Integer> filteredResult = conventionalInterfaces.filterFunction((x -> (Integer) x % 2 == 0), Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Filtered-Result: " + filteredResult);

        List<Integer> filteredUsingRecur = conventionalInterfaces.filterRecur(x -> (Integer) x % 10 == 0, Arrays.asList(10, 20, 30, 45, 50, 55));
        System.out.println("Filter-result-using-recursion: " + filteredUsingRecur);

        List<Integer> mappedResult = conventionalInterfaces.mapFunction(x -> (Integer) x * (Integer) x, Arrays.asList(1, 2, 3, 4));
        System.out.println("Mapped-Result: " + mappedResult);

        List<Integer> mappedResultUsingRecur = conventionalInterfaces.mapRecur((x -> (Integer) x * (Integer) x), Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Mapped-result-using-recursion: " + mappedResultUsingRecur);

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
