package gusev.java23.j1_04.task3;

public class ResultTable {
    private int[][] gasSupplyInfo = new int[6][4];
    private double[][] priceInfo = new double[6][2];
    private String[][] allInfo = new String[7][7];

    ResultTable() {
        for (int i = 0; i < gasSupplyInfo.length; i++) {
            for (int j = 0; j < gasSupplyInfo[i].length; j++)
                gasSupplyInfo[i][j] = 0;
        }
        for (int i = 0; i < priceInfo.length; i++) {
            for (int j = 0; j < priceInfo[i].length; j++)
                priceInfo[i][j] = 0.0;
        }
        allInfo[0][0] = "Поставщики";
        allInfo[0][1] = "АЗС А";
        allInfo[0][2] = "АЗС Б";
        allInfo[0][3] = "АЗС В";
        allInfo[0][4] = "АЗС Г";
        allInfo[0][5] = "Стоимость закупки";
        allInfo[0][6] = "С учетом доставки";
        for (int i = 1; i<allInfo[0].length; i++)
            allInfo[i][0] = Integer.toString(i);
    }

    public void addCostGasSupplyCell(int supplier, int gasStation, int info) {
        for (int i = 0; i < gasSupplyInfo.length; i++) {
            for (int j = 0; j < gasSupplyInfo[i].length; j++)
                if (i == supplier && j == gasStation)
                    gasSupplyInfo[i][j] = gasSupplyInfo[i][j] + info;
        }
    }

    public void addCostPriceCell(int supplier, double price, double priceWithShippingCost) {
        for (int i = 0; i < priceInfo.length; i++) {
            if (i == supplier) {
                priceInfo[i][0] = priceInfo[i][0] + price;
                priceInfo[i][1] = priceInfo[i][1] + priceWithShippingCost;
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < gasSupplyInfo.length; i++) {
            for (int j = 0; j < gasSupplyInfo[i].length; j++) {
                allInfo[i+1][j+1] = Integer.toString(gasSupplyInfo[i][j]);
            }
        }
        for (int i = 0; i < priceInfo.length; i++) {
            for (int j = 0; j < priceInfo[i].length; j++) {
                allInfo[i+1][j+5] = Double.toString(priceInfo[i][j]);
            }
        }
        for (int i = 0; i < allInfo.length; i++) {
            for (int j = 0; j < allInfo[i].length; j++) {
                System.out.format("%15s",allInfo[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
