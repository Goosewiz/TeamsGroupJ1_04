package gusev.java23.j1_04.task3;

import java.util.Arrays;
import java.util.Collections;

public class GasolineSupplies {
    private final int[] MAX_AMOUNT = {600, 420, 360, 250, 700, 390};
    private int[] maxAmount = {600, 420, 360, 250, 700, 390};//переменная, в которой будет хранится остаток реальных возможных поставок
    private final double[] PRICE_PER_UNIT = {5.2, 4.5, 6.1, 3.8, 6.4, 5.6};
    private final int[] COST_FROM_0 = {803, 952, 997, 931};
    private final int[] COST_FROM_1 = {967, 1012, 848, 1200};
    private final int[] COST_FROM_2 = {825, 945, 777, 848};
    private final int[] COST_FROM_3 = {1024, 1800, 931, 999};
    private final int[] COST_FROM_4 = {754, 817, 531, 628};
    private final int[] COST_FROM_5 = {911, 668, 865, 1526};
    private final int[][] ALL_COST = new int[6][4];
    private int[] gasStationNeeds = new int[4];

    {
        ALL_COST[0] = COST_FROM_0;
        ALL_COST[1] = COST_FROM_1;
        ALL_COST[2] = COST_FROM_2;
        ALL_COST[3] = COST_FROM_3;
        ALL_COST[4] = COST_FROM_4;
        ALL_COST[5] = COST_FROM_5;
    }

    GasolineSupplies(int amountA, int amountB, int amountC, int amountD) {
        this.gasStationNeeds[0] = amountA;
        this.gasStationNeeds[1] = amountB;
        this.gasStationNeeds[2] = amountC;
        this.gasStationNeeds[3] = amountD;
    }
    public int findNumberOfSupplier() {
        double[] temp = PRICE_PER_UNIT.clone();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < PRICE_PER_UNIT.length; j++) {
                if (temp[i] == PRICE_PER_UNIT[j] && maxAmount[j] > 0) {
                    return j;
                }
            }
        }
        return -1;
    }

    public int findNumberOfGasStation(int numberOfSupplier) {
        int[] temp = ALL_COST[numberOfSupplier].clone();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < ALL_COST[numberOfSupplier].length; j++) {
                if (ALL_COST[numberOfSupplier][j] == temp[i] && gasStationNeeds[j] > 0) {
                    return j;
                }
            }
        }
        return -1;
    }

    public double solveProblem(ResultTable rs) {
        double price = 0;
        double priceWithShipment = 0;
        int numberOfSupplier = findNumberOfSupplier();
        if (numberOfSupplier == -1)
            return Double.NaN;
        int numberOfGasStation = findNumberOfGasStation(numberOfSupplier);
        if (numberOfGasStation == -1)
            return Double.NaN;
        if (gasStationNeeds[numberOfGasStation] < maxAmount[numberOfSupplier]) {
            price = price + gasStationNeeds[numberOfGasStation] * PRICE_PER_UNIT[numberOfSupplier];
            rs.addCostGasSupplyCell(numberOfSupplier, numberOfGasStation, gasStationNeeds[numberOfGasStation]);
            //System.out.println(price + " цена без поставки " + (numberOfSupplier + 1) + " - номер поставщика " + (numberOfGasStation + 1) + " - номер АЗС");
            priceWithShipment = price + ALL_COST[numberOfSupplier][numberOfGasStation];
            rs.addCostPriceCell(numberOfSupplier, price, priceWithShipment);
            //System.out.println(price + " цена с поставкой " + (numberOfSupplier + 1) + " - номер поставщика " + (numberOfGasStation + 1) + " - номер АЗС");
            maxAmount[numberOfSupplier] = maxAmount[numberOfSupplier] - gasStationNeeds[numberOfGasStation];
            gasStationNeeds[numberOfGasStation] = 0;
        } else {
            price = price + maxAmount[numberOfSupplier] * PRICE_PER_UNIT[numberOfSupplier];
            rs.addCostGasSupplyCell(numberOfSupplier, numberOfGasStation, maxAmount[numberOfSupplier]);
            //System.out.println(price + " цена без поставки " + (numberOfSupplier + 1) + " - номер поставщика " + (numberOfGasStation + 1) + " - номер АЗС");
            priceWithShipment = price + ALL_COST[numberOfSupplier][numberOfGasStation];
            rs.addCostPriceCell(numberOfSupplier, price, priceWithShipment);
            //System.out.println(price + " цена с поставкой " + (numberOfSupplier + 1) + " - номер поставщика " + (numberOfGasStation + 1) + " - номер АЗС");
            gasStationNeeds[numberOfGasStation] = gasStationNeeds[numberOfGasStation] - maxAmount[numberOfSupplier];
            maxAmount[numberOfSupplier] = 0;
            priceWithShipment = priceWithShipment + solveProblem(rs);
        }
        return priceWithShipment;
    }
    public int findNumberOfGasStationBetter() {
        int[] temp = gasStationNeeds.clone();
        Arrays.sort(temp);
        for (int i = temp.length - 1; i>-1; i-- ){
            for (int j = 0; j<gasStationNeeds.length; j++)
                if (temp[i]==gasStationNeeds[j] && gasStationNeeds[j] > 0)
                    return j;
        }
        return -1;
    }
    public int findNumberOfSupplierBetter(int numberOfGasStation) {
        double[] temp = PRICE_PER_UNIT.clone();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < PRICE_PER_UNIT.length; j++) {
                if (temp[i] == PRICE_PER_UNIT[j] && maxAmount[j] > 0) {
                    if (gasStationNeeds[numberOfGasStation] < maxAmount[j])
                        return j;
                }
            }
        }
        return -1;
    }
    public double solveProblemBetter(ResultTable rs) {
        double price = 0;
        double priceWithShipment = 0;
        int numberOfGasStation = findNumberOfGasStationBetter();
        if (numberOfGasStation == -1)
            return Double.NaN;
        int numberOfSupplier = findNumberOfSupplierBetter(numberOfGasStation);
        if (numberOfSupplier == -1)
            return Double.NaN;
        if (gasStationNeeds[numberOfGasStation] < maxAmount[numberOfSupplier]) {
            price = price + gasStationNeeds[numberOfGasStation] * PRICE_PER_UNIT[numberOfSupplier];
            rs.addCostGasSupplyCell(numberOfSupplier, numberOfGasStation, gasStationNeeds[numberOfGasStation]);
            //System.out.println(price + " цена без поставки " + (numberOfSupplier + 1) + " - номер поставщика " + (numberOfGasStation + 1) + " - номер АЗС");
            priceWithShipment = price + ALL_COST[numberOfSupplier][numberOfGasStation];
            rs.addCostPriceCell(numberOfSupplier, price, priceWithShipment);
            //System.out.println(price + " цена с поставкой " + (numberOfSupplier + 1) + " - номер поставщика " + (numberOfGasStation + 1) + " - номер АЗС");
            maxAmount[numberOfSupplier] = maxAmount[numberOfSupplier] - gasStationNeeds[numberOfGasStation];
            gasStationNeeds[numberOfGasStation] = 0;
        }
        return priceWithShipment;
    }
}
