package lotto4.domain;

import lotto4.util.MessageConst;

public class Money {
    private int amount;

    private Money(final int amount) {
        this.amount = amount;
    }

    static public Money of(final int amount) {
        return new Money(amount);
    }

    public void increaseAmount(final Money other) {
        final int nextAmount = this.amount + other.amount;
        validateAmount(nextAmount);
        amount = nextAmount;
    }

    public void decreaseAmount(final Money other) {
        final int nextAmount = this.amount - other.amount;
        validateAmount(nextAmount);
        amount = nextAmount;
    }

    private void validateAmount(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(MessageConst.MONEY_AMOUNT_EXCEPTION);
        }
    }
}
