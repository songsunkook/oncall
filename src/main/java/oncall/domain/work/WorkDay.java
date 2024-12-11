package oncall.domain.work;

import java.util.List;

public class WorkDay {

    public static final int MAXIMUM_NAME_LENGTH = 5;

    private Workers workers;

    public WorkDay(List<String> workers) {
        this.workers = new Workers(
            workers.stream()
                .map(Worker::new)
                .toList()
        );
    }

    public Worker pop(Worker beforeWorker) {
        return workers.pop(beforeWorker);
    }
}
