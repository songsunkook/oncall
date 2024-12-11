package oncall.domain.work;

import static oncall.exception.ExceptionMessage.WORKER_NAME_LENGTH_OVERFLOW;

import java.util.Objects;

public class Worker {

    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Worker(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException(WORKER_NAME_LENGTH_OVERFLOW.getMessage(MAXIMUM_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Worker worker = (Worker)o;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
