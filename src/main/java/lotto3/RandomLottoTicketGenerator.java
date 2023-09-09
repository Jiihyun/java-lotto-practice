package lotto3;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoTicketGenerator {
    public LottoTicket generate() {
    final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    return new LottoTicket(numbers);
  }
}
