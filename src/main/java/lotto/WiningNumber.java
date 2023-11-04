package lotto;

public class WiningNumber {

    private final Lotto winningNumber;
    private final int bonusNumber;

    public WiningNumber(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }


    public Rank getTicetRank(Lotto lotto) {
        int matchCount = winningNumber.getMatchCount(lotto);
        boolean isBonus = lotto.contains(bonusNumber);

        return Rank.value(matchCount, isBonus);
    }
}
