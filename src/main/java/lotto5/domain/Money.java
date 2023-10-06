package lotto5.domain;

public class Money {
    private int amount;

    public Money(int amount) {
        validateInput(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public void increase(int amount) {
        int nextAmount = this.amount + amount;
        validateAmount(nextAmount);
        this.amount = nextAmount;
    }

    public void decrease(int amount) {
        int nextAmount = this.amount - amount;
        validateAmount(nextAmount);
        this.amount = nextAmount;
    }

    private static void validateInput(int amount) {
        if (amount % 1_000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위 입니다.");
        }
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수가 될 수 없습니다.");
        }
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean isEqualOrMoreThan(final int amount) {
        return this.amount >= amount;
    }
}
