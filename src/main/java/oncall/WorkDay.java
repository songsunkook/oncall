package oncall;

import java.util.ArrayList;
import java.util.List;

public class WorkDay {

    private final List<String> workers = new ArrayList<>();
    private int cursor = 0;
    private String specialNextWorker = null;

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

    public String peek() {
        return workers.get(cursor);
    }

    public void swap() {
        int next = getNextIdx();
        String i = workers.get(cursor);
        String j = workers.get(next);
        workers.set(cursor, j);
        workers.set(next, i);
    }

    private int getNextIdx() {
        if (cursor + 1 >= workers.size()) {
            return 0;
        }
        return cursor + 1;
    }

    public String pop(String beforeWorker) {
        if (specialNextWorker != null) {
            String result = specialNextWorker;
            specialNextWorker = null;
            return result;
        }
        String result = workers.get(cursor);
        cursor = getNextIdx();
        if (result.equals(beforeWorker)) {
            specialNextWorker = result;
            result = workers.get(cursor);
            cursor = getNextIdx();
            return result;
        }
        return result;
    }
}
