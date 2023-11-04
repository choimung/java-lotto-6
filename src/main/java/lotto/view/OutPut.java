package lotto.view;

import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static lotto.Rank.FOURTH;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;

import lotto.LottoResult;
import org.w3c.dom.ls.LSOutput;

public class OutPut {

    public static void printResult(LottoResult lottoResult){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getLotto(FIFTH)+ "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getLotto(FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getLotto(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getLotto(SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getLotto(FIRST)+ "개");
    }

}
