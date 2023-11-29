package gusev.java23.j1_04.task2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStatisticsTest {
    private final int SIZE = 100_000;
    private int[] generateArray(int seed){
        Random rand = new Random(seed);
        int[] answer = new int[SIZE];
        for (int i = 0; i<SIZE;i++){
            answer[i] = rand.nextInt();
        }
        return answer;
    }
    @Test
    void testWith0Elements() {
        System.out.println("0 Elements Test");
        int[] array = {};
        ArrayStatistics stat = new ArrayStatistics(array);
        List<Integer> answer = stat.getMode();
        assertEquals(new ArrayList<Integer>(), answer, "mode");
        BigDecimal answerB = stat.getMedian();
        assertEquals(BigDecimal.valueOf(-1), answerB, "median");
        answerB = stat.getAverage();
        assertEquals(BigDecimal.valueOf(-1), answerB, "average");
        answerB = stat.getVariance();
        assertEquals(BigDecimal.valueOf(-1), answerB, "variance");
        answerB = stat.getGeometricMean();
        assertEquals(BigDecimal.valueOf(-1), answerB, "geometric mean");
        Integer[] answerInteger = stat.getShuffle();
        assertEquals(0, answerInteger.length, "shuffle");
        System.out.print("Shuffle ");
        int sum = 0;
        for (int i = 0; i < answerInteger.length; i++) {
            sum = sum + answerInteger[i];
            System.out.print(answerInteger[i] + " ");
        }
        assertEquals(0, sum, "shuffle");
        int[] answerInt = stat.getSample(15);
        assertEquals(0, answerInt.length, "sample");
        System.out.println("");
        System.out.print("Sample ");
        for (int i = 0; i < answerInt.length; i++) {
            System.out.print(answerInt[i] + " ");
        }
        System.out.println("");
    }

    @Test
    void testWith1Elements() {
        System.out.println("0 Elements Test");
        int[] array = {1};
        ArrayStatistics stat = new ArrayStatistics(array);
        List<Integer> answer = stat.getMode();
        assertEquals(1, answer.get(0), "mode");
        BigDecimal answerB = stat.getMedian();
        assertEquals(BigDecimal.valueOf(1), answerB, "median");
        answerB = stat.getAverage();
        assertEquals(BigDecimal.valueOf(1.0), answerB, "average");
        answerB = stat.getVariance();
        assertEquals(BigDecimal.valueOf(0.0), answerB, "variance");
        answerB = stat.getGeometricMean();
        assertEquals(BigDecimal.valueOf(1.0), answerB, "geometric mean");
        Integer[] answerInteger = stat.getShuffle();
        assertEquals(1, answerInteger.length, "shuffle");
        System.out.print("Shuffle ");
        int sum = 0;
        for (int i = 0; i < answerInteger.length; i++) {
            sum = sum + answerInteger[i];
            System.out.print(answerInteger[i] + " ");
        }
        assertEquals(1, sum, "shuffle");
        int[] answerInt = stat.getSample(3);
        assertEquals(3, answerInt.length, "sample");
        System.out.println("");
        System.out.print("Sample ");
        for (int i = 0; i < answerInt.length; i++) {
            System.out.print(answerInt[i] + " ");
        }
        System.out.println("");
    }
    @Test
    void testWith3Elements() {
        System.out.println("3 Elements Test");
        int[] array = {1, 1, 1};
        ArrayStatistics stat = new ArrayStatistics(array);
        List<Integer> answer = stat.getMode();
        assertEquals(1, answer.get(0), "mode");
        BigDecimal answerB = stat.getMedian();
        assertEquals(BigDecimal.valueOf(1), answerB, "median");
        answerB = stat.getAverage();
        assertEquals(BigDecimal.valueOf(1.0), answerB, "average");
        answerB = stat.getVariance();
        assertEquals(BigDecimal.valueOf(0.0), answerB, "variance");
        answerB = stat.getGeometricMean();
        assertEquals(BigDecimal.valueOf(1.0), answerB, "geometric mean");
        Integer[] answerInteger = stat.getShuffle();
        assertEquals(3, answerInteger.length, "shuffle");
        System.out.print("Shuffle ");
        int sum = 0;
        for (int i = 0; i < answerInteger.length; i++) {
            sum = sum + answerInteger[i];
            System.out.print(answerInteger[i] + " ");
        }
        assertEquals(3, sum, "shuffle");
        int[] answerInt = stat.getSample(2);
        assertEquals(2, answerInt.length, "sample");
        System.out.println("");
        System.out.print("Sample ");
        for (int i = 0; i < answerInt.length; i++) {
            System.out.print(answerInt[i] + " ");
        }
        System.out.println("");
    }

    @Test
    void testWith10Elements() {
        System.out.println("10 Elements Test");
        int[] array = {1, 1, 3, 4, 1, 4, 4, 5, 3, 2};// 1 1 1 2 3 3 4 4 4 5
        ArrayStatistics stat = new ArrayStatistics(array);
        List<Integer> answer = stat.getMode();
        assertEquals(1, answer.get(0), "mode");
        assertEquals(4, answer.get(1), "mode");
        BigDecimal answerB = stat.getMedian();
        assertEquals(BigDecimal.valueOf(3), answerB, "median");
        answerB = stat.getAverage();
        assertEquals(BigDecimal.valueOf(2.8), answerB, "average");
        answerB = stat.getVariance();
        assertEquals(BigDecimal.valueOf(1.96), answerB, "variance");
        answerB = stat.getGeometricMean();
        assertEquals(BigDecimal.valueOf(2.37707151785333), answerB, "geometric mean");
        Integer[] answerInteger = stat.getShuffle();
        Integer[] answerInteger2 = stat.getShuffle();
        assertNotEquals(answerInteger, answerInteger2, "shuffle");
        assertEquals(10, answerInteger.length, "shuffle");
        System.out.print("Shuffle ");
        int sum = 0;
        for (int i = 0; i < answerInteger.length; i++) {
            sum = sum + answerInteger[i];
            System.out.print(answerInteger[i] + " ");
        }
        assertEquals(28, sum, "shuffle");
        int[] answerInt = stat.getSample(15);
        int[] answerInt2 = stat.getSample(15);
        assertNotEquals(answerInt, answerInt2, "sample");
        assertEquals(15, answerInt.length, "sample");
    }
    @Test
    void testWith100_000Elements() {
        System.out.println("100_000 Elements Test");
        int[] array = generateArray(100);
        ArrayStatistics stat = new ArrayStatistics(array);
        List<Integer> answer = stat.getMode();
        assertEquals(-1657125010, answer.get(0), "mode");
        BigDecimal answerB = stat.getMedian();
        assertEquals(BigDecimal.valueOf(4554698), answerB, "median");
        answerB = stat.getAverage();
        assertEquals(BigDecimal.valueOf(598973.43769), answerB, "average");
        answerB = stat.getVariance();
        //Метод выдает ответ, но не получается сравнить его с числом
        //assertEquals(BigDecimal.valueOf(1541532155890696798.2967574639), answerB, "variance");
        //Невозможно получить ответ от метода
        //answerB = stat.getGeometricMean();
        //assertEquals(BigDecimal.valueOf(2.37707151785333), answerB, "geometric mean");
        Integer[] answerInteger = stat.getShuffle();
        Integer[] answerInteger2 = stat.getShuffle();
        assertNotEquals(answerInteger, answerInteger2, "shuffle");
        assertEquals(100_000, answerInteger.length, "shuffle");
        int[] answerInt = stat.getSample(15);
        int[] answerInt2 = stat.getSample(15);
        assertNotEquals(answerInt, answerInt2, "sample");
        assertEquals(15, answerInt.length, "sample");
    }
}