package oncall.domain.day;

import static oncall.exception.ExceptionMessage.INVALID_DAY_OF_WEEK;

import java.util.Arrays;

public enum DayOfWeek {
    일,
    월,
    화,
    수,
    목,
    금,
    토,
    ;

    public static DayOfWeek from(String dayOfTheWeek) {
        return Arrays.stream(values())
            .filter(days -> days.name().equals(dayOfTheWeek))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_DAY_OF_WEEK.getMessage()));
    }

    public DayOfWeek next() {
        if (ordinal() == values().length - 1) {
            return values()[0];
        }
        return values()[ordinal() + 1];
    }

    public boolean isHoliday() {
        return this.equals(토) || this.equals(일);
    }
}
