package oncall;

public class Company {

    private final WorkDay weekday = new WorkDay();
    private final WorkDay holiday = new WorkDay();

    public void assignWeekday(String workers) {
        weekday.assign(workers);
    }

    public void assignHoliday(String workers) {
        holiday.assign(workers);
    }
}
