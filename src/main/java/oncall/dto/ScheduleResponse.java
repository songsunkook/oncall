package oncall.dto;

import java.util.List;

import oncall.domain.company.Schedule;
import oncall.domain.day.DayOfWeek;
import oncall.domain.day.Month;
import oncall.domain.day.SpecialHoliday;

public record ScheduleResponse(
    int month,
    String dayOfWeek,
    List<InnerDays> days
) {

    public static ScheduleResponse from(Schedule schedule) {
        return new ScheduleResponse(
            schedule.getMonth().get(),
            schedule.getDayOfWeek().name(),
            schedule.getDays().stream()
                .map(innerDays -> InnerDays.from(schedule.getMonth(), innerDays))
                .toList()
        );
    }

    public record InnerDays(
        int day,
        DayOfWeek dayOfWeek,
        boolean isSpecialHoliday,
        String worker
    ) {

        private static InnerDays from(Month month, Schedule.InnerDays innerDays) {
            return new InnerDays(
                innerDays.day(),
                innerDays.dayOfWeek(),
                SpecialHoliday.isHoliday(month, innerDays.day()),
                innerDays.worker().getName());
        }
    }
}
