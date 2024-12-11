package oncall.domain.company;

import oncall.domain.day.Days;
import oncall.domain.day.Month;
import oncall.domain.work.Worker;

public class Calendar {

    private Company company;

    public void setUp(Company company) {
        this.company = company;
    }

    public Schedule scheduleWith(int month, String dayOfTheWeekParam) {
        Schedule schedule = new Schedule(month, dayOfTheWeekParam);
        Days dayOfWeek = Days.from(dayOfTheWeekParam);

        Worker beforeWorker = null;
        for (int i = 1; i <= Month.from(month).getLastDay(); i++) {
            Worker result = company.nextWorker(month, i, dayOfWeek, beforeWorker);
            schedule.add(i, dayOfWeek, result);
            beforeWorker = result;
            dayOfWeek = dayOfWeek.next();
        }

        return schedule;
    }
}
