package oncall.view;

import static oncall.view.OutputMessage.*;

import oncall.dto.ScheduleResponse;

public class OutputView {

    private StringBuilder buffer = new StringBuilder();

    public void inputStartDate() {
        print(INPUT_START_DATE.getMessage());
        flush();
    }

    public void inputWorkday() {
        print(INPUT_WORKDAY.getMessage());
        flush();
    }

    public void inputHoliday() {
        print(INPUT_HOLIDAY.getMessage());
        flush();
    }

    public void result(ScheduleResponse response) {
        response.days().forEach(innerDays -> {
                if (innerDays.isSpecialHoliday()) {
                    print(RESULT_SPECIAL_HOLIDAY.getMessage(response.month(), innerDays.day(), innerDays.dayOfWeek(),
                        innerDays.worker()));
                    return;
                }
                print(RESULT.getMessage(response.month(), innerDays.day(), innerDays.dayOfWeek(), innerDays.worker()));
            }
        );
        flush();
    }

    public void exception(Exception e) {
        print(e.getMessage());
        flush();
    }

    private void print(String content) {
        buffer.append(content);
    }

    private void flush() {
        System.out.print(buffer);
        buffer = new StringBuilder();
    }
}
