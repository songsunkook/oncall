package oncall.domain;

import java.util.Arrays;

public enum Days {
    일,
    월,
    화,
    수,
    목,
    금,
    토,
    ;

    public static Days from(String dayOfTheWeek) {
        return Arrays.stream(values())
            .filter(days -> days.name().equals(dayOfTheWeek))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] "));
    }

    public Days next() {
        if (ordinal() == values().length - 1) {
            return values()[0];
        }
        return values()[ordinal() + 1];
    }

    public boolean isHoliday() {
        return this.equals(토) || this.equals(일);
    }
}
