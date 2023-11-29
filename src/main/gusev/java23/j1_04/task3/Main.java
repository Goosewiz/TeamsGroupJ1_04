package gusev.java23.j1_04.task3;

public class Main {
    public static void main(String[] args) {
        int amountA = InputCheck.inputCheck("Введите объем поставки для АЗС А\n");
        int amountB = InputCheck.inputCheck("Введите объем поставки для АЗС Б\n");
        int amountC = InputCheck.inputCheck("Введите объем поставки для АЗС В\n");
        int amountD = InputCheck.inputCheck("Введите объем поставки для АЗС Г\n");
        GasolineSupplies gs = new GasolineSupplies(amountA, amountB, amountC, amountD);
        ResultTable rs = new ResultTable();
        double answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = answer + gs.solveProblem(rs);
        }
        rs.printTable();
        System.out.println("Общая цена: " + answer);
    }
}
