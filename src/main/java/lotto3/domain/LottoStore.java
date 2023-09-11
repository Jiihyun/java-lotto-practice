package lotto3.domain;

import lotto2.domain.RandomNumbersGenerator;

public class LottoStore {
    public static final Money TICKET_PRICE = Money.of(1_000);
    private final RandomLottoTicketGenerator randomLottoTicketGenerator;

    public LottoStore(RandomLottoTicketGenerator randomLottoTicketGenerator) {
        this.randomLottoTicketGenerator = randomLottoTicketGenerator;
    }

    public LottoTicket buy(final Money wallet) {
         wallet.decrease(TICKET_PRICE);
        return randomLottoTicketGenerator.generate();
    }
}
