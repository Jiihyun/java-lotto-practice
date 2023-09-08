package lotto2.domain;

import lotto2.util.MessageConst;
import lotto2.util.NumberConst;

import static lotto2.util.MessageConst.*;

public final class Money {
    private int amount;

    private Money(final int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public void increase(final Money other) {
        this.amount += other.amount;
    }

    public void decrease(final Money other) {
        final int nextAmount = amount - other.amount;
        validateAmount(nextAmount);
        amount = nextAmount;
    }

    public static Money of(final int amount) {
        //imp - 정적 팩토리 메서드
        return new Money(amount);
    }

    public void validateAmount(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(MONEY_AMOUNT_EXCEPTION);
        }
    }

    public boolean isEqualOrMoreThan(final Money other) {
        return amount >= other.amount;
    }

    public int getAmount() {
        return amount;
    }
}
