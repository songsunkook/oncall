package oncall;

import org.junit.jupiter.api.Test;

class WorkDayTest {

    @Test
    void 순번에_따라_비상_근무일을_배정한다() {
        WorkDay workDay = new WorkDay();
        workDay.assign("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
    }

    @Test
    void 회사에서는_평일과_휴일_순번을_다르게_운영한다() {
        Company company = new Company();
        company.assignWeekday("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        company.assignHoliday("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");
    }
}
