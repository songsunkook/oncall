package oncall.dto;

public record StartDateRequest(
   int month,
   String dayOfWeek
) {

    public static StartDateRequest from(String input) {
        try {
            String[] split = input.split(",");
            return new StartDateRequest(Integer.parseInt(split[0]), split[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("[ERROR]");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

}
