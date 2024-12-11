package oncall.service;

import oncall.Calendar;
import oncall.Company;
import oncall.Schedule;
import oncall.StartDate;

public class OncallService {

    private StartDate startDate;
    private final Calendar calendar = new Calendar();
    private final Company company = new Company();

    public void setUp(String input) {
        String[] split = input.split(",");
        startDate = new StartDate(Integer.parseInt(split[0]), split[1]);
        calendar.setUp(company);
    }

    public void setWorkday(String workday) {
        company.assignWeekday(workday);
    }

    public void setHoliday(String holiday) {
        company.assignHoliday(holiday);
    }

    public Schedule result() {
        return calendar.scheduleWith(startDate.getMonth(), startDate.getDayOfWeek());
    }
}
