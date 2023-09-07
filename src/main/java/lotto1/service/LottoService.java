package lotto1.service;

import lotto1.model.Lotto;
import lotto1.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto1.util.NumberConst.*;

public class LottoService {
    RandomNumberGenerator randomNumberGenerator;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int lottoPriceToCount(int inputPrice) {
        return inputPrice / UNIT_OF_AMOUNT;
    }

    public List<Lotto> createLottoLists(int lottoCount) {
        int count = 0;
        ArrayList<Lotto> lottos = new ArrayList<>();
        while (count < lottoCount) {
            List<Integer> numbers = randomNumberGenerator.generateLottoNumberInAscending();
            lottos.add(new Lotto(numbers));
            count++;
        }
        return lottos;
    }

    public Lotto toLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Integer> compareList(List<Lotto> lottoList, Lotto inputNum) {
        ArrayList<Integer> winningStatisticsList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int sameNumberCount = lotto.compareNumber(inputNum);
            if (sameNumberCount >= 3) {
                winningStatisticsList.add(sameNumberCount);
            }
        }
        return winningStatisticsList;
    }

    public int getCountOfFiveWithBonus(List<Lotto> lottoList, Lotto inputNum, int inputBonusNumber) {
        int countOfFive = 0;
        for (Lotto lotto : lottoList) {
            int sameNumberCount = lotto.compareNumber(inputNum);
            boolean isIncludeBonusNum = lotto.compareBonusNum(inputBonusNumber);
            if (sameNumberCount == 5 && isIncludeBonusNum) {
                countOfFive++;
            }
        }
        return countOfFive;
    }

    public int getCountOfThree(List<Integer> winningStatisticsList) {
        int count = 0;
        for (Integer number : winningStatisticsList) {
            if (number == 3) {
                count++;
            }
        }
        return count;
    }

    public int getCountOfFour(List<Integer> winningStatisticsList) {
        int count = 0;
        for (Integer number : winningStatisticsList) {
            if (number == 4) {
                count++;
            }
        }
        return count;
    }


    public int getCountOfFive(List<Lotto> lottoList, Lotto inputNum, int inputBonusNumber) {
        int countOfFive = 0;
        for (Lotto lotto : lottoList) {
            int sameNumberCount = lotto.compareNumber(inputNum);
            boolean isIncludeBonusNum = lotto.compareBonusNum(inputBonusNumber);
            if (sameNumberCount == 5 && !isIncludeBonusNum) {
                countOfFive++;
            }
        }
        return countOfFive;
    }

    public int getCountOfSix(List<Integer> winningStatisticsList) {
        int count = 0;
        for (Integer number : winningStatisticsList) {
            if (number == 6) {
                count++;
            }
        }
        return count;
    }

}
