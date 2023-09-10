package lotto3.domain;

public class Money {
    private int amount;

    public Money(final int amount) {
        this.amount = amount;
    }

    public void increase(final int amount) {
        this.amount += amount;
    }

    public void decrease(final int amount) {
        this.amount -= amount;
    }
}
