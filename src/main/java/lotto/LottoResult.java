package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    Map<Rank, Integer> map;
    private List<Rank> ranks;
    private int amount;

    //누적 반환
    public int getLotto(Rank rank){
        return map.getOrDefault(rank, 0);
    }


    public Map<Rank, Integer> calculateRankCounts(List<Rank> ranks){
        map = new HashMap<>();
        for (Rank rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) +1);
        }
        return map;
    }

    public void calculateProfit(List<Rank> ranks, int money){
        int sum = ranks.stream()
                .mapToInt(Rank::getAmount)
                .sum();

        System.out.println("총 수익률은 " + (double) (sum * 100) / money + "%입니다.");


    }

}
