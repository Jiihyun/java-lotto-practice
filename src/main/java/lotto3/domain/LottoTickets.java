package lotto3.domain;

import lotto3.domain.LottoTicket;

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

    public LottoDrawingResults drawResults(final List<Integer> winningNumbers, final int bonusNumber ) {
        final List<LottoDrawingResult> lottoDrawingResults = new ArrayList<>();

        for (final LottoTicket lottoTicket : lottoTickets) {
            final LottoDrawingResult lottoDrawingResult = lottoTicket.drawResult(winningNumbers, bonusNumber);
            lottoDrawingResults.add(lottoDrawingResult);
        }
        return LottoDrawingResults.of(lottoDrawingResults);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n%d개를 구매했습니다.\n", lottoTickets.size()));
        for (LottoTicket lottoTicket : lottoTickets) {
            sb.append(lottoTicket.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
