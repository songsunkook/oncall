package oncall.dto;

import java.util.List;

public record ScheduleRequest(
    List<String> workers
) {

    public static ScheduleRequest from(String input) {
        List<String> workers = List.of(input.split(","));
        validateDuplicateWorker(workers);
        return new ScheduleRequest(workers);
    }

    private static void validateDuplicateWorker(List<String> workers) {
        if (workers.size() != workers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
