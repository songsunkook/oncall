package oncall.dto;

import java.util.List;

import oncall.domain.Days;
import oncall.domain.Schedule;

public record ScheduleResponse(
    int month,
    String dayOfWeek,
    List<InnerDays> days
) {

    public static ScheduleResponse from(Schedule schedule) {
        return new ScheduleResponse(
            schedule.getMonth(),
            schedule.getDayOfWeek(),
            schedule.getDays().stream()
                .map(InnerDays::from)
                .toList()
        );
    }

    public record InnerDays(
        int day,
        Days dayOfWeek,
        String worker
    ) {

        private static InnerDays from(Schedule.InnerDays innerDays) {
            return new InnerDays(innerDays.day(), innerDays.dayOfWeek(), innerDays.worker());
        }
    }
}
