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
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

    public int getMonth() {
        return month;
    }

    public String getDayOfWeek() {
        return dayOfWeek.name();
    }
}
