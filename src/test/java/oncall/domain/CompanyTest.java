package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import oncall.domain.company.Company;
import oncall.domain.company.Schedule;
import oncall.domain.day.StartDate;

class CompanyTest {

    @Test
    void 회사에서는_평일과_휴일_순번을_다르게_운영한다() {
        Company company = new Company();
        company.assignWeekday(List.of("준팍", "도밥", "고니", "수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리"));
        company.assignHoliday(List.of("수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리", "준팍", "도밥", "고니"));
    }

    @Test
    void 연속_2일_근무하는_경우_다음_근무자와_순서를_바꾼다() {
        Company company = new Company();
        company.assignWeekday(List.of("준팍", "도밥", "고니", "수아", "루루"));
        company.assignHoliday(List.of("준팍", "고니", "도밥", "수아", "루루"));
        StartDate startDate = new StartDate(1, "월");
        Schedule schedule = company.getSchedule(startDate);
        assertThat(schedule.getWorker(1).getName()).isEqualTo("준팍");
        assertThat(schedule.getWorker(2).getName()).isEqualTo("도밥");
        assertThat(schedule.getWorker(3).getName()).isEqualTo("준팍");
        assertThat(schedule.getWorker(4).getName()).isEqualTo("고니");
        assertThat(schedule.getWorker(5).getName()).isEqualTo("수아");
        assertThat(schedule.getWorker(6).getName()).isEqualTo("고니");
        assertThat(schedule.getWorker(7).getName()).isEqualTo("도밥");
    }
}
