package oncall.dto;

import static oncall.exception.ExceptionMessage.INVALID_START_DATE_INPUT;

public record StartDateRequest(
   int month,
   String dayOfWeek
) {

    public static final String DELIMITER = ",";
    public static final int MONTH_INDEX = 0;
    public static final int DAY_OF_WEEK_INDEX = 1;

    public static StartDateRequest from(String input) {
        try {
            String[] split = input.split(DELIMITER);
            return new StartDateRequest(Integer.parseInt(split[MONTH_INDEX]), split[DAY_OF_WEEK_INDEX]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_START_DATE_INPUT.getMessage());
        }
    }

}
