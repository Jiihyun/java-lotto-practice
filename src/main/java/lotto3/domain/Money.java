package lotto3.domain;

public class Money {
    private int amount;

    public Money(final int amount) {
        this.amount = amount;
    }

    public void increase(final Money customerMoney) {
        int nextAmount = this.amount + customerMoney.amount;
        validateAmount(nextAmount);
        this.amount = nextAmount;
    }

    public void decrease(final Money customerMoney ) {
        int nextAmount = this.amount - customerMoney.amount;
        validateAmount(nextAmount);
        this.amount = nextAmount;
    }

    //imp - 금액을 직접 변경하는 것이 아닌, Money 클래스에 돈을 증감시키는 메소드를 만들어서 간접적으로 변경하도록 할 것
    // -> 한 번더 추상화 시키기
    // buy할 때 마다 매번 검증하는 로직을 작성하지 않아도 됨
    public void validateAmount(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] - 잔고가 부족합니다.");
        }
    }
}
