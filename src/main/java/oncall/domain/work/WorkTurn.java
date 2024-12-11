package oncall.domain.work;

import java.util.List;

public class WorkTurn {

    private Workers workers;

    public WorkTurn(List<String> workers) {
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
