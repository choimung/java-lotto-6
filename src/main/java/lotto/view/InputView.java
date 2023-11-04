package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TYPE_ERROR = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int inputAmount(){
        while (true) {
            try {
                System.out.print(INPUT_LOTTO_AMOUNT);
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }

    public static List<Integer> inputWinningNumbers(){
        System.out.println("\n"+INPUT_WINNING_NUMBERS);
        return Arrays.stream((Console.readLine().split(","))).map(Integer::parseInt).toList();
    }

    public static int inputBonusNumber(){
        System.out.println("\n"+INPUT_BONUS_NUMBER);
        return stringToInt(Console.readLine());
    }


    private static int stringToInt(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }
}
