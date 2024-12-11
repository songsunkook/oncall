package oncall.domain.company;

import java.util.List;

import oncall.domain.day.Days;
import oncall.domain.day.SpecialHoliday;
import oncall.domain.work.WorkDay;
import oncall.domain.work.Worker;

public class Company {

    private WorkDay weekday;
    private WorkDay holiday;

    public void assignWeekday(List<String> workers) {
        weekday = new WorkDay(workers);
    }

    public void assignHoliday(List<String> workers) {
        holiday = new WorkDay(workers);
    }

    public Worker nextWorker(int month, int day, Days days, Worker beforeWorker) {
        if (SpecialHoliday.isHoliday(month, day) || days.isHoliday()) {
            return holiday.pop(beforeWorker);
        }
        return weekday.pop(beforeWorker);
    }
}
