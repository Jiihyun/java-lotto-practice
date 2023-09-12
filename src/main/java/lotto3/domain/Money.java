package lotto3.domain;

public class Money {
    private int amount;

    private Money(final int amount) {
        this.amount = amount;
    }

    //increase 할 때 인자가 Money 클래스 이므로 잔액이 양수임이 항상 보장되므로 검증로직 추가 안해도 되긴 함
    public void increase(final Money customerMoney) {
        int nextAmount = this.amount + customerMoney.amount;
        validateAmount(nextAmount);
        this.amount = nextAmount;
        //this.amount += customerMoney.amount;
    }

    public void decrease(final Money customerMoney) {
        int nextAmount = this.amount - customerMoney.amount;
        validateAmount(nextAmount);
        this.amount = nextAmount;
    }

    //imp - 금액을 직접 변경하는 것이 아닌, Money 클래스에 돈을 증감시키는 메소드를 만들어서 간접적으로 변경하도록 할 것
    // -> 한 번더 추상화 시키기
    // buy 할 때 마다 매번 검증하는 로직을 작성하지 않아도
    private void validateAmount(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] - 잔고가 부족합니다.");
        }
    }

    public boolean isEqualOrMoreThan(final Money customerMoney) {
        return this.amount >= customerMoney.amount;
    }

    //객체 생성의 역할을 하는 클래스 메서드  - Static Factory Method
    public static Money of(final int amount) {
        return new Money(amount);
    }

    public Money multiplied(final int times) {
        final int nextAmount = amount * times;
        validateAmount(nextAmount);
        return Money.of(nextAmount);
    }

    //imp- getAmount를 꺼내와서 사용해도 int 타입이므로 값이 복사되어 변경이 일어나도 원본에 영향을 미치지 않을 것이므로 안전
    public int getAmount() {
        return amount;
    }
}
