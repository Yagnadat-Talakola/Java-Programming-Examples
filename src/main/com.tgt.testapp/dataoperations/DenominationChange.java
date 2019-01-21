package com.tgt.testapp.dataoperations;

import java.util.HashMap;
import java.util.Map;

public class DenominationChange {

    Map<Integer, Integer> countDenominationMap;

    public void setCountDenominationMap(Map<Integer, Integer> countDenominationMap) {
        this.countDenominationMap = countDenominationMap;
    }

    public Map<Integer, Integer> getCountDenominationMap() {
        return countDenominationMap;
    }

    public Integer countIterations(int amount, int denominationCount) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || denominationCount == 0) {
            return 0;
        } else {
            return (countIterations((amount - getCountDenominationMap().get(denominationCount)), denominationCount) +
                    countIterations(amount, (denominationCount - 1)));
        }
    }

    public static void main(String[] args) {
        DenominationChange changeCount = new DenominationChange();

        Map<Integer, Integer> countDenomMap = new HashMap<>();
        countDenomMap.put(5, 50);
        countDenomMap.put(4, 25);
        countDenomMap.put(3, 10);
        countDenomMap.put(2, 5);
        countDenomMap.put(1, 1);

        changeCount.setCountDenominationMap(countDenomMap);
        System.out.println(changeCount.countIterations(100, 5));
    }
}
