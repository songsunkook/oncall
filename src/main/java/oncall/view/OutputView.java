package oncall.view;

import oncall.domain.Schedule;
import oncall.domain.SpecialHoliday;

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

    public static void result(Schedule schedule) {
        String format = "%d월 %d일 %s %s%n";
        String specialHolidayFormat = "%d월 %d일 %s(휴일) %s%n";
        schedule.getDays().forEach(innerDays -> {
                if (SpecialHoliday.isHoliday(schedule.getMonth(), innerDays.day())) {
                    System.out.printf(specialHolidayFormat, schedule.getMonth(), innerDays.day(), innerDays.dayOfWeek(),
                        innerDays.worker());
                    return;
                }
                System.out.printf(format, schedule.getMonth(), innerDays.day(), innerDays.dayOfWeek(),
                    innerDays.worker());
            }
        );
    }

    public static void exception(Exception e) {
        System.out.println(e.getMessage());
    }
}
