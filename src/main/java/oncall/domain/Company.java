package oncall.domain;

import java.util.List;

public class Company {

    private WorkDay weekday;
    private WorkDay holiday;

    public void assignWeekday(List<String> workers) {
        weekday = new WorkDay(workers);
    }

    public void assignHoliday(List<String> workers) {
        holiday = new WorkDay(workers);
    }

    public String nextWorker(int month, int day, Days days, String beforeWorker) {
        if (SpecialHoliday.isHoliday(month, day) || days.isHoliday()) {
            return holiday.pop(beforeWorker);
        }
        return weekday.pop(beforeWorker);
    }
}
