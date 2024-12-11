package oncall;

import org.junit.jupiter.api.Test;

class WorkDayTest {

    @Test
    void 순번에_따라_비상_근무일을_배정한다() {
        WorkDay workDay = new WorkDay();
        workDay.assign("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
    }
}
