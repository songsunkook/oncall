package oncall;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private final int month;
    private final List<InnerDays> days = new ArrayList<>();

    public Schedule(int month) {
        this.month = month;
    }

    public void add(int day, String worker) {
        days.add(new InnerDays(day, worker));
    }

    public String getWorker(int day) {
        return days.get(day - 1).worker;
    }

    public record InnerDays(
        int day,
        String worker
    ) {

    }
}
