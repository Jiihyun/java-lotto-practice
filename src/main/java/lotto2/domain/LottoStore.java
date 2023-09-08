package lotto2.domain;

import java.util.ArrayList;

import static lotto2.util.NumberConst.*;

public final class LottoStore {
    public static final Money TICKET_PRICE = Money.of(UNIT_OF_AMOUNT);
    private final RandomNumbersGenerator randomNumbersGenerator;

    public LottoStore(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public LottoTicket buy(final Money wallet) {
        wallet.decrease(TICKET_PRICE);
        return new LottoTicket(randomNumbersGenerator.generate(6));
    }

    public LottoTickets buyMany(final Money wallet) {
        final ArrayList<LottoTicket> boughtTickets = new ArrayList<>();

        while (wallet.isEqualOrMoreThan(TICKET_PRICE)) {
            final LottoTicket boughtTicket = buy(wallet);
            boughtTickets.add(boughtTicket);
        }
        return LottoTickets.of(boughtTickets);
    }

}
