package oncall.domain;

import java.util.List;

public class Calendar {

    private static final List<Integer> _31days = List.of(1, 3, 5, 7, 8, 10, 12);

    private Company company;

    public void setUp(Company company) {
        this.company = company;
    }

    public Schedule scheduleWith(int month, String dayOfTheWeek) {
        return calculateSchedule(month, dayOfTheWeek, _31days.contains(month) ? 31 : 30);
    }

    private Schedule calculateSchedule(int month, String dayOfTheWeekParam, int lastDay) {
        Schedule schedule = new Schedule(month, dayOfTheWeekParam);
        Days dayOfWeek = Days.from(dayOfTheWeekParam);

        String beforeWorker = null;
        for (int i = 1; i <= lastDay; i++) {
            String result = company.nextWorker(month, i, dayOfWeek, beforeWorker);
            schedule.add(i, dayOfWeek, result);
            beforeWorker = result;
            dayOfWeek = dayOfWeek.next();
        }

        return schedule;
    }
}
