package gusev.java23.j1_04.task1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class DatesRangeTest {

    @Test
    void weekendCount() {
        LocalDate date1 = LocalDate.of(2023, Month.NOVEMBER, 12);
        LocalDate date2 = LocalDate.of(2023, Month.NOVEMBER, 13);
        LocalDate date3 = LocalDate.of(2023, Month.NOVEMBER, 14);
        LocalDate[] answer = DatesRange.weekendCount(date1, date3);
        assertEquals(3, answer.length);
        assertEquals(date1, answer[0]);
        assertEquals(date2, answer[1]);
        assertEquals(date3, answer[2]);
        LocalDate dateNull = null;
        answer = DatesRange.weekendCount(date1, dateNull);
        assertEquals(0, answer.length);
        answer = DatesRange.weekendCount(dateNull, date3);
        assertEquals(0, answer.length);
    }
}