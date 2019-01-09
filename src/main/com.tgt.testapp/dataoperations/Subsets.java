package com.tgt.testapp.dataoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    /*
       (1) ()

       [() (1)] 2

       (1) (2)
       (1 2) () (1) (2)
       (1 2) () (1) (2) (2 3) (1 2 3) (3) (1 3)

       (1 2 3) ()
       all the subsets of (1 2 3) -> ((1) (2) (3) () (1 2) (2 3) (3 1) (1 2 3)) append
       all the subsets of (1 2 3 4) -> ((1 4) (2 4) (3 4) (4) (1 2 4) (2 3 4) (3 1 4) (1 2 3 4))

     */

    public static void main(String[] args) {

        Subsets subsets = new Subsets();
        List<Integer> input = Arrays.asList(1, 2);
        List<List<Integer>> result = subsets.splitList(input);
        System.out.println(result);
    }

    public List<List<Integer>> splitList (List<Integer> inputList) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i = 0; i < inputList.size(); i++) {
            computeSubsets(result, inputList.get(i));
        }

        return result;
    }

    private void computeSubsets(List<List<Integer>> list, Integer appendVal){

        int listsize = list.size();

        for(int i = 0 ; i < listsize; i++) {
            List<Integer> newVal = new ArrayList<>();
            newVal.add(appendVal);
            for(int y = 0; y < list.get(i).size(); y++) {
                newVal.add(list.get(i).get(y));
            }
            list.add(newVal);
        }


    }


}
