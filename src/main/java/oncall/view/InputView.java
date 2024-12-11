package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.ScheduleRequest;
import oncall.dto.StartDateRequest;

public class InputView {

    public static StartDateRequest startDate() {
        return StartDateRequest.from(Console.readLine());
    }

    public static ScheduleRequest workday() {
        return ScheduleRequest.from(Console.readLine());
    }

    public static ScheduleRequest holiday() {
        return ScheduleRequest.from(Console.readLine());
    }

    private InputView() {
    }
}
