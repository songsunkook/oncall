package oncall;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private final int month;
    private final String dayOfWeek;
    private final List<InnerDays> days = new ArrayList<>();

    public Schedule(int month, String dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public void add(int day, Days dayOfWeek, String worker) {
        days.add(new InnerDays(day, dayOfWeek, worker));
    }

    public String getWorker(int day) {
        return days.get(day - 1).worker;
    }

    public int getMonth() {
        return month;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public List<InnerDays> getDays() {
        return days;
    }

    public record InnerDays(
        int day,
        Days dayOfWeek,
        String worker
    ) {

    }
}
