package oncall.domain;

import static oncall.constant.OncallConstant.MAXIMUM_WORKER_COUNT;
import static oncall.constant.OncallConstant.MINIMUM_WORKER_COUNT;
import static oncall.exception.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.List;

public class WorkDay {

    public static final int MAXIMUM_NAME_LENGTH = 5;

    private int cursor = 0;
    private String specialNextWorker = null;
    private final List<String> workers = new ArrayList<>();

    public WorkDay(List<String> workers) {
        validateNumberOfPeople(workers);
        validateNickname(workers);
        this.workers.addAll(workers);
    }

    private void validateNumberOfPeople(List<String> workers) {
        if (workers.size() > MAXIMUM_WORKER_COUNT) {
            throw new IllegalArgumentException(WORKER_OVERFLOW.getMessage());
        }
        if (workers.size() < MINIMUM_WORKER_COUNT) {
            throw new IllegalArgumentException(WORKER_UNDERFLOW.getMessage());
        }
    }

    private void validateNickname(List<String> workers) {
        if (workers.stream().anyMatch(name -> name.length() > MAXIMUM_NAME_LENGTH)) {
            throw new IllegalArgumentException(WORKER_NAME_LENGTH_OVERFLOW.getMessage(MAXIMUM_NAME_LENGTH));
        }
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
