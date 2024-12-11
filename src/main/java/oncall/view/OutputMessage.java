package oncall.view;

public enum OutputMessage {
    INPUT_START_DATE("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    INPUT_WORKDAY("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    INPUT_HOLIDAY("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    RESULT("%d월 %d일 %s %s%n"),
    RESULT_SPECIAL_HOLIDAY("%d월 %d일 %s(휴일) %s%n"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
