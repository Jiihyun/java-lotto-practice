package lotto5.domain;

import lotto5.controller.DrawingResult;

import java.util.List;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Lottos lottos;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber, Lottos lottos) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    public DrawingResult draw() {
        return null;
    }
}
