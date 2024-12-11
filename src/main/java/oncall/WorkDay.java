package oncall;

import java.util.ArrayList;
import java.util.List;

public class WorkDay {

    private final List<String> workers = new ArrayList<>();

    public void assign(String workers) {
        List<String> split = List.of(workers.split(","));
        validateDuplicateWorker(split);
        this.workers.addAll(split);
    }

    private void validateDuplicateWorker(List<String> workers) {
        if (workers.size() != workers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
