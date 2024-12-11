package oncall.controller;

import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final OncallService oncallService = new OncallService();

    public void run() {
        process(this::inputMonthAndDays);
        process(this::inputSchedule);
        process(this::result);
    }

    private void inputMonthAndDays() {
        OutputView.inputMonthAndDays();
        oncallService.setUp(InputView.startDate());
    }

    private void inputSchedule() {
        OutputView.inputWorkday();
        oncallService.setWorkday(InputView.workday());
        OutputView.inputHoliday();
        oncallService.setHoliday(InputView.holiday());
    }

    private void result() {
        OutputView.result(oncallService.result());
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.exception(e);
            process(action);
        }
    }
}