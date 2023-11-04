package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public int getMatchCount(Lotto lotto){
        List<Integer> lottoNumbers = lotto.sortLottoNumbers();
        List<Integer> thisNumbers = new ArrayList<>(this.numbers);
        thisNumbers.retainAll(lottoNumbers);
        return thisNumbers.size();
    }

    public List<Integer> sortLottoNumbers() {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6자리입니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복 되었습니다.");
        }
    }

}
