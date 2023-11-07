package lotto.domain;

import java.util.List;

import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {


    LottoStore lottoStore = new LottoStore();
    LottoResult lottoResult = new LottoResult();

    Player player;
    WinningNumber winningNumber;


    public void run() {
        player = generateLottoTickets();
        winningNumber = creatWinningNumber();
        evaluateProfitAndPrintResults(player, winningNumber);
    }

    public Player generateLottoTickets() {
        int playerMoney = InputView.inputAmount();
        int lottoTicketCount = lottoStore.calculateLottoTicketCount(playerMoney);
        List<Lotto> playerLottoTickets = lottoStore.buyLottoTickets(lottoTicketCount);
        OutputView.printBuyLottoCount(lottoTicketCount);
        OutputView.PrintUserLottoTickets(playerLottoTickets);
        return new Player(playerLottoTickets, playerMoney);
    }


    public WinningNumber creatWinningNumber() {
        return new WinningNumber(new Lotto(InputView.inputWinningNumbers()), InputView.inputBonusNumber());
    }

    public void evaluateProfitAndPrintResults(Player player, WinningNumber winningNumber) {
        List<LottoRank> lottoRanks = player.checkLottoTickets(winningNumber);
        lottoResult.calculateRankCounts(lottoRanks);
        double profit = lottoResult.calculateProfit(lottoRanks, player.getMoney());
        OutputView.printUserPrizeStats(lottoResult);
        OutputView.PrintUserProfit(profit);
    }


}
