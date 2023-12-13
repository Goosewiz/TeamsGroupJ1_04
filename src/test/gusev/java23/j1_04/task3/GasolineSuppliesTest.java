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
        assertEquals(13572.0, answer);
        gs = new GasolineSupplies(amountA, amountB, amountC, amountD);
        rs = new ResultTable();
        double betterAnswer = 0;
        for (int i = 0; i < 4; i++) {
            betterAnswer = betterAnswer + gs.solveProblemBetter(rs);
        }
        assertEquals(12326.0, betterAnswer);
        assertTrue(answer > betterAnswer);
    }
}