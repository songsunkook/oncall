package oncall.domain;

public class Company {

    private final WorkDay weekday = new WorkDay();
    private final WorkDay holiday = new WorkDay();

    public void assignWeekday(String workers) {
        weekday.assign(workers);
    }

    public void assignHoliday(String workers) {
        holiday.assign(workers);
    }

    public String nextWorker(int month, int day, Days days, String beforeWorker) {
        if (SpecialHoliday.isHoliday(month, day) || days.isHoliday()) {
            return holiday.pop(beforeWorker);
        }
        return weekday.pop(beforeWorker);
    }
}
