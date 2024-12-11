package oncall;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WorkDayTest {

    @Test
    void 순번에_따라_비상_근무일을_배정한다() {
        WorkDay workDay = new WorkDay();
        workDay.assign("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
    }

    @Test
    void 순번에_특정_인원이_두번이상_편성된_경우_예외를_반환한다() {
        WorkDay workDay = new WorkDay();
        assertThatThrownBy(() -> workDay.assign("준팍,도밥,고니,글로,글로,글로"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
