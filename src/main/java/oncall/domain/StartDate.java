package oncall.domain;

public class StartDate {

    private final int month;
    private final Days dayOfWeek;

    public StartDate(int month, String dayOfWeek) {
        validateMonth(month);
        this.month = month;
        this.dayOfWeek = Days.from(dayOfWeek);
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 월(month)입니다.");
        }
    }

    public int getMonth() {
        return month;
    }

    public String getDayOfWeek() {
        return dayOfWeek.name();
    }
}
