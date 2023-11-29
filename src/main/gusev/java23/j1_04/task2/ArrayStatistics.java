package gusev.java23.j1_04.task2;

import java.math.BigDecimal;
import java.util.*;

public class ArrayStatistics {
    private final int[] array;
    private final int[] sortedArray;

    ArrayStatistics(int[] array) {
        this.array = array;
        sortedArray = array.clone();
        Arrays.sort(sortedArray);
    }

    public List<Integer> getMode() {
        if (sortedArray.length == 0)
            return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(sortedArray[0]);
        if (sortedArray.length == 1)
            return list;
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] != sortedArray[i - 1]) {
                if (count > maxCount) {
                    maxCount = count;
                    list = new ArrayList<Integer>();
                    list.add(sortedArray[i - 1]);
                } else if (count == maxCount) {
                    list.add(sortedArray[i - 1]);
                }
                count = 1;
            } else {
                count = count + 1;
            }
        }
        if (count > maxCount) {
            list = new ArrayList<Integer>();
            list.add(sortedArray[sortedArray.length - 1]);
        } else if (count == maxCount) {
            list.add(sortedArray[sortedArray.length - 1]);
        }
        return list;
    }

    public BigDecimal getMedian() {
        if (sortedArray.length == 0)
            return BigDecimal.valueOf(-1);
        if (sortedArray.length % 2 == 0) {
            return BigDecimal.valueOf((sortedArray[sortedArray.length / 2 - 1] + sortedArray[sortedArray.length / 2]) / 2);
        } else
            return BigDecimal.valueOf(sortedArray[sortedArray.length / 2]);
    }

    public BigDecimal getAverage() {
        if (sortedArray.length == 0)
            return BigDecimal.valueOf(-1);
        BigDecimal answer = BigDecimal.valueOf(0.0);
        for (int i = 0; i < sortedArray.length; i++) {
            answer = answer.add(BigDecimal.valueOf(sortedArray[i]));
        }
        answer = answer.divide(BigDecimal.valueOf(sortedArray.length));
        return answer;
    }

    public BigDecimal getVariance() {
        if (sortedArray.length == 0)
            return BigDecimal.valueOf(-1);
        BigDecimal average = getAverage();
        BigDecimal answer = BigDecimal.valueOf(0.0);
        for (int i = 0; i < sortedArray.length; i++) {
            BigDecimal temp = average.subtract(BigDecimal.valueOf(sortedArray[i]));
            if (!temp.equals(BigDecimal.valueOf(0.0))) {
                BigDecimal bd = temp.pow(2);
                answer = answer.add(bd);
            }
        }
        answer.add(BigDecimal.valueOf(1.0));
        answer = answer.divide(BigDecimal.valueOf(sortedArray.length));
        return answer;
    }

    public BigDecimal getGeometricMean() {
        if (sortedArray.length == 0)
            return BigDecimal.valueOf(-1);
        BigDecimal answer = BigDecimal.valueOf(1.0);
        for (int i = 0; i < sortedArray.length; i++) {
            answer = answer.multiply(BigDecimal.valueOf(sortedArray[i]));
        }
        double temp = answer.doubleValue();
        temp = Math.pow(temp, 1.0 / sortedArray.length);
        answer = BigDecimal.valueOf(temp);
        //answer = answer.pow(1/sortedArray.length);
        return answer;
    }

    public Integer[] getShuffle() {
        if (sortedArray.length == 0)
            return new Integer[0];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        Collections.shuffle(list);
        Integer[] answer = list.toArray(new Integer[0]);
        return answer;
    }

    public int[] getSample(int size) {
        if (sortedArray.length == 0)
            return new int[0];
        int[] answer = new int[size];
        Random rand = new Random();
        int position = 0;
        for (int i = 0; i < size; i++) {
            position = rand.nextInt(array.length);
            answer[i] = array[position];
        }
        return answer;
    }
}
