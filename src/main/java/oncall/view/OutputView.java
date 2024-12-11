package oncall.view;

import static oncall.view.OutputMessage.*;

import oncall.dto.ScheduleResponse;

public class OutputView {

    public static void inputStartDate() {
        System.out.print(INPUT_START_DATE.getMessage());
    }

    public static void inputWorkday() {
        System.out.print(INPUT_WORKDAY.getMessage());
    }

    public static void inputHoliday() {
        System.out.print(INPUT_HOLIDAY.getMessage());
    }

    public static void result(ScheduleResponse response) {
        response.days().forEach(innerDays -> {
                if (innerDays.isSpecialHoliday()) {
                    System.out.print(RESULT_SPECIAL_HOLIDAY.getMessage(response.month(), innerDays.day(), innerDays.dayOfWeek(),
                        innerDays.worker()));
                    return;
                }
                System.out.print(RESULT.getMessage(response.month(), innerDays.day(), innerDays.dayOfWeek(), innerDays.worker()));
            }
        );
    }

    public static void exception(Exception e) {
        System.out.println(e.getMessage());
    }

    private OutputView() {
    }
}
