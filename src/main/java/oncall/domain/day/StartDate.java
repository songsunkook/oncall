package oncall.domain.day;

import static oncall.constant.OncallConstant.MAXIMUM_MONTH;
import static oncall.constant.OncallConstant.MINIMUM_MONTH;
import static oncall.exception.ExceptionMessage.INVALID_MONTH;

public class StartDate {

    private final Month month;
    private final DayOfWeek dayOfWeek;

    public StartDate(int month, String dayOfWeek) {
        validateMonth(month);
        this.month = Month.from(month);
        this.dayOfWeek = DayOfWeek.from(dayOfWeek);
    }

    private void validateMonth(int month) {
        if (month < MINIMUM_MONTH || month > MAXIMUM_MONTH) {
            throw new IllegalArgumentException(INVALID_MONTH.getMessage());
        }
    }

    public Month getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
