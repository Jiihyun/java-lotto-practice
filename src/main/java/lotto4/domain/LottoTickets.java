package lotto4.domain;

import lotto4.util.MessageConst;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(final List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(final List<Lotto> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int ticketCount() {
        return lottoTickets.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoTickets.size()).append(MessageConst.TICKET_AMOUNT_CONFIRM_MSG);
        for (Lotto lottoTicket : lottoTickets) {
            sb.append(lottoTicket.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
