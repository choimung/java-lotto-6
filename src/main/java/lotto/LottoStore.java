package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public List<Lotto> buyLotto(int count){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < count; i++){
            lottoList.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoList;
    }
}
