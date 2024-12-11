package oncall.domain;

import java.util.List;

public class Company {

    private final WorkDay weekday = new WorkDay();
    private final WorkDay holiday = new WorkDay();

    public void assignWeekday(List<String> workers) {
        weekday.assign(workers);
    }

    public void assignHoliday(List<String> workers) {
        holiday.assign(workers);
    }

    public String nextWorker(int month, int day, Days days, String beforeWorker) {
        if (SpecialHoliday.isHoliday(month, day) || days.isHoliday()) {
            return holiday.pop(beforeWorker);
        }
        return weekday.pop(beforeWorker);
    }
}
