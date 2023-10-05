package lotto5.exceptions;

public class BonusNumberInputException extends IllegalArgumentException {
    public BonusNumberInputException() {
        super("보너스 번호는 반드시 숫자를 입력하셔야 합니다.");
    }
}
