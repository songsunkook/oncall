package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CompanyTest {

    @Test
    void 회사에서는_평일과_휴일_순번을_다르게_운영한다() {
        Company company = new Company();
        company.assignWeekday("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        company.assignHoliday("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");
    }

    @Test
    void 연속_2일_근무하는_경우_다음_근무자와_순서를_바꾼다() {
        Company company = new Company();
        company.assignWeekday("준팍,도밥,고니,수아,루루");
        company.assignHoliday("준팍,고니,도밥,수아,루루");
        Calendar calendar = new Calendar();
        calendar.setUp(company);
        Schedule schedule = calendar.scheduleWith(1, "월");
        assertThat(schedule.getWorker(1)).isEqualTo("준팍");
        assertThat(schedule.getWorker(2)).isEqualTo("도밥");
        assertThat(schedule.getWorker(3)).isEqualTo("준팍");
        assertThat(schedule.getWorker(4)).isEqualTo("고니");
        assertThat(schedule.getWorker(5)).isEqualTo("수아");
        assertThat(schedule.getWorker(6)).isEqualTo("고니");
        assertThat(schedule.getWorker(7)).isEqualTo("도밥");
    }
}
