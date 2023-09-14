package lotto4.domain;

import lotto4.util.MessageConst;
import lotto4.util.NumberConst;

import static lotto4.util.NumberConst.*;

public class Money {
    private int amount;

    public int getAmount() {
        return amount;
    }

    private Money(final int amount) {
        validateUnitOfPrice(amount);
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

    private void validateUnitOfPrice(final int amount) {
        if (amount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(MessageConst.MONEY_INPUT_EXCEPTION);
        }
    }

    public boolean isEqualOrMoreThanLottoTicketPrice() { // question - money 타입으로 받은 이유
        return amount >= LOTTO_TICKET_PRICE;
    }


}
