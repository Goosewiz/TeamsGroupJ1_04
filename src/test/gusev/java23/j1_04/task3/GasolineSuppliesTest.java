package gusev.java23.j1_04.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasolineSuppliesTest {

    @Test
    void solveProblem() {
        int amountA = 400;
        int amountB = 550;
        int amountC = 280;
        int amountD = 310;
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