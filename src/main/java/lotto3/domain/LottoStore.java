package lotto3.domain;

public class LottoStore {
    public static final Money TICKET_PRICE = Money.of(1_000);
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoStore(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public LottoTicket buy(final Money wallet) {
         wallet.decrease(TICKET_PRICE);
        return randomNumberGenerator.generate();
    }
}
