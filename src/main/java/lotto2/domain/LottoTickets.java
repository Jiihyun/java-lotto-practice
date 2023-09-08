package lotto2.domain;

import lotto2.util.MessageConst;
import lotto2.util.NumberConst;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(final List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public LottoDrawingResults drawResults(final List<Integer> winningNumbers, final int bonusNumber) {
        final List<LottoDrawingResult> lottoDrawingResults = new ArrayList<>();

        for (final LottoTicket lottoTicket : lottoTickets) {
            lottoDrawingResults.add(lottoTicket.drawResult(winningNumbers, bonusNumber));
        }
        return LottoDrawingResults.of(lottoDrawingResults);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(lottoTickets.size()).append(MessageConst.LOTTO_COUNT_MSG).append("\n");

        for (final LottoTicket lottoTicket : lottoTickets) {

            sb.append(lottoTicket.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
