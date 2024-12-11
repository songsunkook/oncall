package oncall.domain;

import static oncall.constant.OncallConstant.MAXIMUM_MONTH;
import static oncall.constant.OncallConstant.MINIMUM_MONTH;
import static oncall.exception.ExceptionMessage.INVALID_MONTH;

import oncall.domain.day.Days;

public class StartDate {

    private final int month;
    private final Days dayOfWeek;

    public StartDate(int month, String dayOfWeek) {
        validateMonth(month);
        this.month = month;
        this.dayOfWeek = Days.from(dayOfWeek);
    }

    private void validateMonth(int month) {
        if (month < MINIMUM_MONTH || month > MAXIMUM_MONTH) {
            throw new IllegalArgumentException(INVALID_MONTH.getMessage());
        }
    }

    public int getMonth() {
        return month;
    }

    public String getDayOfWeek() {
        return dayOfWeek.name();
    }
}
