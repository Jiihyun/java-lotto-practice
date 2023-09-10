package lotto3.domain;

import lotto3.domain.LottoTicket;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

  public LottoTickets(final List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }
}
