package lotto4.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private RandomNumberGenerator randomNumberGenerator;

    public LottoTickets buyMany(Money receivedMoney) {
        List<Lotto> boughtTickets = new ArrayList<>();

        while (receivedMoney.isEqualOrMoreThanLottoTicketPrice()) {
            Lotto boughtTicket = buy(receivedMoney);
            boughtTickets.add(boughtTicket);
        }
        return LottoTickets.of(boughtTickets);
    }

    private Lotto buy(Money receivedMoney) {
        receivedMoney.decreaseAmount(receivedMoney);
        return randomNumberGenerator.generateNumbers();
    }
}
