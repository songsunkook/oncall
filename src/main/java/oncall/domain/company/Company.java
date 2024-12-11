package oncall.domain.company;

import java.util.List;

import oncall.domain.day.DayOfWeek;
import oncall.domain.day.Month;
import oncall.domain.day.SpecialHoliday;
import oncall.domain.day.StartDate;
import oncall.domain.work.WorkTurn;
import oncall.domain.work.Worker;

public class Company {

    private WorkTurn weekdayTurn;
    private WorkTurn holidayTurn;

    public void assignWeekday(List<String> workers) {
        weekdayTurn = new WorkTurn(workers);
    }

    public void assignHoliday(List<String> workers) {
        holidayTurn = new WorkTurn(workers);
    }

    public Worker nextWorker(Month month, int day, DayOfWeek dayOfWeek, Worker beforeWorker) {
        if (SpecialHoliday.isHoliday(month, day) || dayOfWeek.isHoliday()) {
            return holidayTurn.pop(beforeWorker);
        }
        return weekdayTurn.pop(beforeWorker);
    }

    public Schedule getSchedule(StartDate startDate) {
        Worker beforeWorker = null;
        Month month = startDate.getMonth();
        DayOfWeek dayOfWeek = startDate.getDayOfWeek();
        Schedule schedule = new Schedule(month, dayOfWeek);

        for (int i = 1; i <= month.getLastDay(); i++) {
            Worker result = nextWorker(month, i, dayOfWeek, beforeWorker);
            schedule.add(i, dayOfWeek, result);
            beforeWorker = result;
            dayOfWeek = dayOfWeek.next();
        }

        return schedule;
    }
}
