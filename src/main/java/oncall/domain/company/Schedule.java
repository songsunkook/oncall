package oncall.domain.company;

import java.util.ArrayList;
import java.util.List;

import oncall.domain.day.DayOfWeek;
import oncall.domain.day.Month;
import oncall.domain.work.Worker;

public class Schedule {

    private final Month month;
    private final DayOfWeek dayOfWeek;
    private final List<InnerDays> days = new ArrayList<>();

    public Schedule(Month month, DayOfWeek dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public void add(int day, DayOfWeek dayOfWeek, Worker worker) {
        days.add(new InnerDays(day, dayOfWeek, worker));
    }


    public Worker getWorker(int day) {
        return days.get(day - 1).worker;
    }

    public Month getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public List<InnerDays> getDays() {
        return days;
    }

    public record InnerDays(
        int day,
        DayOfWeek dayOfWeek,
        Worker worker
    ) {

    }
}
