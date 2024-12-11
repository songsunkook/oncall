package oncall.service;

import oncall.domain.StartDate;
import oncall.domain.company.Calendar;
import oncall.domain.company.Company;
import oncall.dto.ScheduleRequest;
import oncall.dto.ScheduleResponse;
import oncall.dto.StartDateRequest;

public class OncallService {

    private StartDate startDate;
    private final Calendar calendar = new Calendar();
    private final Company company = new Company();

    public void setUp(StartDateRequest request) {
        startDate = new StartDate(request.month(), request.dayOfWeek());
        calendar.setUp(company);
    }

    public void setWorkday(ScheduleRequest request) {
        company.assignWeekday(request.workers());
    }

    public void setHoliday(ScheduleRequest request) {
        company.assignHoliday(request.workers());
    }

    public ScheduleResponse result() {
        return ScheduleResponse.from(calendar.scheduleWith(startDate.getMonth(), startDate.getDayOfWeek()));
    }
}
