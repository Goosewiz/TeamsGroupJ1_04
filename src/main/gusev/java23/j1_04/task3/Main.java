package gusev.java23.j1_04.task3;

public class Main {
    public static void main(String[] args) {
        int amountA = InputCheck.inputCheck("Введите объем поставки для АЗС А\n");
        int amountB = InputCheck.inputCheck("Введите объем поставки для АЗС Б\n");
        int amountC = InputCheck.inputCheck("Введите объем поставки для АЗС В\n");
        int amountD = InputCheck.inputCheck("Введите объем поставки для АЗС Г\n");
        /*int amountA = 400;
        int amountB = 550;
        int amountC = 280;
        int amountD = 310;*/
        GasolineSupplies gs = new GasolineSupplies(amountA, amountB, amountC, amountD);
        ResultTable rs = new ResultTable();
        double answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = answer + gs.solveProblem(rs);
        }
        rs.printTable();
        System.out.println("Общая цена: " + answer);
        System.out.println("Результат работы улучшенного алгоритма:");
        gs = new GasolineSupplies(amountA, amountB, amountC, amountD);
        rs = new ResultTable();
        answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = answer + gs.solveProblemBetter(rs);
        }
        rs.printTable();
        System.out.println("Общая цена: " + answer);
    }
}
