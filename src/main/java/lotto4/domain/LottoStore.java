package lotto4.domain;

import lotto4.util.NumberConst;

import java.util.ArrayList;
import java.util.List;

import static lotto4.util.NumberConst.*;

public class LottoStore {
    private RandomNumberGenerator randomNumberGenerator;

    public LottoStore(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Money TICKET_PRICE = Money.of(LOTTO_TICKET_PRICE);

    public LottoTickets buyMany(Money receivedMoney) {
        List<Lotto> boughtTickets = new ArrayList<>();

        while (receivedMoney.isEqualOrMoreThanLottoTicketPrice()) {
            Lotto boughtTicket = buy(receivedMoney);
            boughtTickets.add(boughtTicket);
        }
        return LottoTickets.of(boughtTickets);
    }

    private Lotto buy(Money receivedMoney) {
        receivedMoney.decreaseAmount(TICKET_PRICE);
        return randomNumberGenerator.generateNumbers();
    }
}
