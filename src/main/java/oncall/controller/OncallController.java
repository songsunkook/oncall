package oncall.controller;

import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final OncallService oncallService = new OncallService();
    private final OutputView outputView = new OutputView();

    public void run() {
        process(this::inputMonthAndDays);
        process(this::inputSchedule);
        process(this::result);
    }

    private void inputMonthAndDays() {
        outputView.inputStartDate();
        oncallService.setUp(InputView.startDate());
    }

    private void inputSchedule() {
        outputView.inputWorkday();
        oncallService.setWorkday(InputView.workday());
        outputView.inputHoliday();
        oncallService.setHoliday(InputView.holiday());
    }

    private void result() {
        outputView.result(oncallService.result());
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.exception(e);
            process(action);
        }
    }
}
