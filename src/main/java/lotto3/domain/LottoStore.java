package lotto3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final Money TICKET_PRICE = Money.of(1_000);
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoStore(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public LottoTicket buy(final Money wallet) {
         wallet.decrease(TICKET_PRICE);
        return new LottoTicket(randomNumberGenerator.generate(6));
    }

    public LottoTickets buyMany(final Money wallet) {
        final List<LottoTicket> boughtTickets = new ArrayList<>();

        while (wallet.isEqualOrMoreThan(TICKET_PRICE)) {
            final LottoTicket boughtTicket = buy(wallet);
            boughtTickets.add(boughtTicket);
        }
        return LottoTickets.of(boughtTickets);
    }
}
