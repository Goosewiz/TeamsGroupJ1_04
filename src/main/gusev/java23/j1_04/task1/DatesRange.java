package gusev.java23.j1_04.task1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DatesRange {
    public static LocalDate[] weekendCount(LocalDate date1, LocalDate date2) {
        if ((date1 == null) || (date2 == null))
            return new LocalDate[0];
        long result = ChronoUnit.DAYS.between(date1, date2) + 1;
        LocalDate[] answer = new LocalDate[(int) result];
        for (int i = 0; i < result; i++) {
            answer[i] = date1;
            date1 = date1.plusDays(1);
        }
        return answer;
    }
}
