package oncall.view;

import oncall.domain.SpecialHoliday;
import oncall.dto.ScheduleResponse;

public class OutputView {

    public static void inputMonthAndDays() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public static void inputWorkday() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public static void inputHoliday() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public static void result(ScheduleResponse response) {
        String format = "%d월 %d일 %s %s%n";
        String specialHolidayFormat = "%d월 %d일 %s(휴일) %s%n";
        response.days().forEach(innerDays -> {
                if (SpecialHoliday.isHoliday(response.month(), innerDays.day())) {
                    System.out.printf(specialHolidayFormat, response.month(), innerDays.day(), innerDays.dayOfWeek(),
                        innerDays.worker());
                    return;
                }
                System.out.printf(format, response.month(), innerDays.day(), innerDays.dayOfWeek(),
                    innerDays.worker());
            }
        );
    }

    public static void exception(Exception e) {
        System.out.println(e.getMessage());
    }
}
