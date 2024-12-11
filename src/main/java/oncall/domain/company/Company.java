package oncall.domain.company;

import java.util.List;

import oncall.domain.day.Days;
import oncall.domain.day.SpecialHoliday;
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

    public Worker nextWorker(int month, int day, Days days, Worker beforeWorker) {
        if (SpecialHoliday.isHoliday(month, day) || days.isHoliday()) {
            return holidayTurn.pop(beforeWorker);
        }
        return weekdayTurn.pop(beforeWorker);
    }
}
