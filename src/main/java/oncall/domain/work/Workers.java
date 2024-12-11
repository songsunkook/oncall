package oncall.domain.work;

import static oncall.constant.OncallConstant.MAXIMUM_WORKER_COUNT;
import static oncall.constant.OncallConstant.MINIMUM_WORKER_COUNT;
import static oncall.exception.ExceptionMessage.WORKER_OVERFLOW;
import static oncall.exception.ExceptionMessage.WORKER_UNDERFLOW;

import java.util.List;

public class Workers {

    private int cursor = 0;
    private Worker specialNextWorker = null;
    private final List<Worker> workers;

    public Workers(List<Worker> workers) {
        validateNumberOfPeople(workers);
        this.workers = workers;
    }

    private void validateNumberOfPeople(List<Worker> workers) {
        if (workers.size() > MAXIMUM_WORKER_COUNT) {
            throw new IllegalArgumentException(WORKER_OVERFLOW.getMessage());
        }
        if (workers.size() < MINIMUM_WORKER_COUNT) {
            throw new IllegalArgumentException(WORKER_UNDERFLOW.getMessage());
        }
    }

    public Worker pop(Worker beforeWorker) {
        if (specialNextWorker != null) {
            Worker result = specialNextWorker;
            specialNextWorker = null;
            return result;
        }
        Worker result = workers.get(cursor);
        cursor = getNextIdx();
        if (result.equals(beforeWorker)) {
            specialNextWorker = result;
            result = workers.get(cursor);
            cursor = getNextIdx();
            return result;
        }
        return result;
    }

    private int getNextIdx() {
        if (cursor + 1 >= workers.size()) {
            return 0;
        }
        return cursor + 1;
    }
}
