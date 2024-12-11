package oncall;

import org.junit.jupiter.api.Test;

class CompanyTest {

    @Test
    void 회사에서는_평일과_휴일_순번을_다르게_운영한다() {
        Company company = new Company();
        company.assignWeekday("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        company.assignHoliday("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");
    }
}
