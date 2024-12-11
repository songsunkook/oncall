package oncall.domain.day;

import java.util.Arrays;

public enum SpecialHoliday {
    신정(Month._1월, 1),
    삼일절(Month._3월, 1),
    어린이날(Month._5월, 5),
    현충일(Month._6월, 6),
    광복절(Month._8월, 15),
    개천절(Month._10월, 3),
    한글날(Month._10월, 9),
    성탄절(Month._12월, 25),
    ;

    private final Month month;
    private final int day;

    SpecialHoliday(Month month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(Month month, int day) {
        return Arrays.stream(values())
            .anyMatch(specialHoliday -> specialHoliday.month == month && specialHoliday.day == day);
    }
}
