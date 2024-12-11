package oncall.dto;

import static oncall.exception.ExceptionMessage.DUPLICATE_WORKER_IN_ONCE_SCHEDULE;

import java.util.List;

public record ScheduleRequest(
    List<String> workers
) {

    public static final String DELIMITER = ",";

    public static ScheduleRequest from(String input) {
        List<String> workers = List.of(input.split(DELIMITER));
        validateDuplicateWorker(workers);
        return new ScheduleRequest(workers);
    }

    private static void validateDuplicateWorker(List<String> workers) {
        if (workers.size() != workers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_WORKER_IN_ONCE_SCHEDULE.getMessage());
        }
    }
}
