package lotto4.domain;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(final List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(final List<Lotto> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }
}
