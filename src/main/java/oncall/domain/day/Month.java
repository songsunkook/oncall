package oncall.domain.day;

public enum Month {
    _1월(31),
    _2월(30),
    _3월(31),
    _4월(30),
    _5월(31),
    _6월(30),
    _7월(31),
    _8월(31),
    _9월(30),
    _10월(31),
    _11월(30),
    _12월(31),
    ;

    private final int lastDay;

    Month(int lastDay) {
        this.lastDay = lastDay;
    }

    public int getLastDay() {
        return lastDay;
    }

    public static Month from(int month) {
        return values()[month - 1];
    }
}
