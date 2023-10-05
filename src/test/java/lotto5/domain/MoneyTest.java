package lotto5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @DisplayName("돈을 1000원 단위로 생성")
    @Test
    void createMoney() {
        //given
        int amount = 1000;
        //when
        Money money = new Money(amount);
        //then
        assertThat(money
                .getAmount()).isEqualTo(1000);
    }

    @DisplayName("돈을 1000원 단위 아니라면 생성 시 예외 발생")
    @Test
    void createMoneyFailure() {
        //given
        int amount = 999;
        //when
        //then
        assertThatThrownBy(() -> new Money(amount)).isInstanceOf(IllegalArgumentException.class).hasMessage("로또 구입 금액은 1000원 단위 입니다.");
    }

    @Test
    void Money는_양수로_증가할_수_있다() {
        //given
        Money money = new Money(1000);
        int amount = 200;
        //when
        money.increase(amount);
        //then
        assertThat(money.getAmount()).isEqualTo(1200);
    }

    @Test
    void Money는_음수로_증가할_수_없다() {
        //given
        Money money = new Money(1000);
        int amount = 2000;
        //when+then
        assertThatThrownBy(() -> money.decrease(amount)).isInstanceOf(IllegalArgumentException.class).hasMessage("금액은 음수가 될 수 없습니다.");
    }
}