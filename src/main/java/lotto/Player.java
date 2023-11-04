package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
public class Player {

    private final List<Lotto> lottoList;

    public Player(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Rank> getRanks(WiningNumber winingNumber){
        return lottoList.stream()
                .map(winingNumber::getTicetRank)
                .toList();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
