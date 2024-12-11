package oncall;

import java.util.ArrayList;
import java.util.List;

public class WorkDay {

    private final List<String> workers = new ArrayList<>();

    public void assign(String workers) {
        this.workers.addAll(List.of(workers.split(",")));
    }
}
