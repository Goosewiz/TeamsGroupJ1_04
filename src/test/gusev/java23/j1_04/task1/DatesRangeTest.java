package gusev.java23.j1_04.task1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class DatesRangeTest {

    @Test
    void weekendCount() {
        LocalDate date1 = LocalDate.of(2023, Month.NOVEMBER, 12);
        LocalDate date2 = LocalDate.of(2023, Month.NOVEMBER, 11);
        LocalDate[] answer = DatesRange.weekendCount(date1, date2);
        assertEquals(0, answer.length);
        date1 = LocalDate.of(2023, Month.FEBRUARY, 28);
        date2 = LocalDate.of(2023, Month.FEBRUARY, 28);
        answer = DatesRange.weekendCount(date1, date2);
        assertEquals(1, answer.length);
        assertEquals(LocalDate.of(2023,Month.FEBRUARY, 28), answer[0]);
        date1 = LocalDate.of(2020, Month.MAY, 28);
        date2 = LocalDate.of(2020, Month.JUNE, 02);
        answer = DatesRange.weekendCount(date1, date2);
        assertEquals(6, answer.length);
        assertEquals(LocalDate.of(2020,Month.MAY, 28), answer[0]);
        assertEquals(LocalDate.of(2020,Month.JUNE, 02), answer[answer.length-1]);
        date1 = LocalDate.of(1901, Month.JANUARY, 01);
        date2 = LocalDate.of(1901, Month.DECEMBER, 31);
        answer = DatesRange.weekendCount(date1, date2);
        assertEquals(365, answer.length);
        assertEquals(LocalDate.of(1901, Month.JANUARY, 01), answer[0]);
        assertEquals(LocalDate.of(1901, Month.DECEMBER, 31), answer[answer.length-1]);
    }
}