package oncall.controller;

import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final OncallService oncallService = new OncallService();

    public void run() {
        OutputView.inputMonthAndDays();
        oncallService.setUp(InputView.monthAndDays());

        OutputView.inputWorkday();
        oncallService.setWorkday(InputView.workday());
        OutputView.inputHoliday();
        oncallService.setHoliday(InputView.holiday());

        OutputView.result(oncallService.result());
    }
}
