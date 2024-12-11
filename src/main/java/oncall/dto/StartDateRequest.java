package oncall.dto;

import static oncall.exception.ExceptionMessage.INVALID_START_DATE_INPUT;

public record StartDateRequest(
   int month,
   String dayOfWeek
) {

    public static StartDateRequest from(String input) {
        try {
            String[] split = input.split(",");
            return new StartDateRequest(Integer.parseInt(split[0]), split[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_START_DATE_INPUT.getMessage());
        }
    }

}
