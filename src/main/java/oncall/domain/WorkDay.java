package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkDay {

    private int cursor = 0;
    private String specialNextWorker = null;
    private final List<String> workers = new ArrayList<>();

    public WorkDay(List<String> workers) {
        validateNumberOfPeople(workers);
        validateNickname(workers);
        this.workers.addAll(workers);
    }

    private void validateNumberOfPeople(List<String> workers) {
        if (workers.size() > 35) {
            throw new IllegalArgumentException("[ERROR] 근무자 수는 최대 35명이어야 합니다.");
        }
        if (workers.size() < 5) {
            throw new IllegalArgumentException("[ERROR] 근무자 수는 최소 5명 이상이어야 합니다.");
        }
    }

    private void validateNickname(List<String> workers) {
        if (workers.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("[ERROR] 근무자 닉네임은 최대 5글자여야 합니다.");
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
