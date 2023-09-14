package lotto4.domain;

public class LottoDrawingMachine {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoDrawingMachine() {
    }

    public void drawNumbers(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoDrawingResults compareResult(LottoTickets boughtTickets) {
        return boughtTickets.getResults(winningNumbers, bonusNumber);
    }
}
