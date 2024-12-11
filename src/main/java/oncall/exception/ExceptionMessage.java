package oncall.exception;

import oncall.constant.OncallConstant;

public enum ExceptionMessage {
    INVALID_MONTH("올바르지 않은 월(month)입니다."),
    INVALID_DAY_OF_WEEK("올바르지 않은 요일입니다."),
    INVALID_START_DATE_INPUT("올바르지 않은 시작 날짜입니다."),
    WORKER_UNDERFLOW(String.format("근무자 수는 최소 %d명 이상이어야 합니다.",
        OncallConstant.MINIMUM_WORKER_COUNT)),
    WORKER_OVERFLOW(String.format("근무자 수는 최대 %d명이어야 합니다.",
        OncallConstant.MAXIMUM_WORKER_COUNT)),
    WORKER_NAME_LENGTH_OVERFLOW("근무자 닉네임은 최대 %d글자여야 합니다."),
    DUPLICATE_WORKER_IN_ONCE_SCHEDULE("각 근무자는 하나의 순번에 1회만 편성되어야 합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해주세요.";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(PREFIX + message + POSTFIX, args);
    }
}
