package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutPut;

public class LottoGame {

    LottoStore lottoStore = new LottoStore();
    WiningNumber winingNumber;
    Lotto lotto;

    public void run(){
        int amount = InputView.inputAmount();
        System.out.print("\n"+amount / 1000 + "개를 구매했습니다.");
        List<Lotto> lottoList = lottoStore.buyLotto(amount / 1000);
        Player player = new Player(lottoList);

        System.out.println();
        PrintPlayerLotto(lottoList);


        List<Integer> winningNumbers = inputWinningNumbers();
        Lotto winningNumber = new Lotto(winningNumbers);

        int bonusNumber = InputView.inputBonusNumber();
        winingNumber = new WiningNumber(winningNumber,bonusNumber);

        List<Rank> ranks = player.getRanks(winingNumber);


        // -- 로또 리절트 객체 생성 --
        LottoResult lottoResult = new LottoResult();
        // -- 합 출력

        lottoResult.calculateRankCounts(ranks);


        OutPut outPut = new OutPut();
        outPut.printResult(lottoResult);

        lottoResult.calculateProfit(ranks, amount);



//        List<Rank> rankList = player.getLottoList().stream()
//                .map(i -> winingNumber.getTicetRank(i))
//                .toList();

//        for (Rank rank : rankList) {
//            Rank ra = rank;
//            System.out.println(ra.getMessage());
//        }


    }


    public void MatchNumber(List<Lotto> lotto){
    }

    public List<Integer> inputWinningNumbers(){
        return InputView.inputWinningNumbers();
    }

    public void PrintPlayerLotto(List<Lotto> lotto){
        lotto.forEach(i -> System.out.println(i.sortLottoNumbers()));
    }


}
