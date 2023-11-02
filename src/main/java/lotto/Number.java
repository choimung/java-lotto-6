package lotto;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    public Number(String inputNumber) {
        validateNumeric(inputNumber);
        validateNumberInRange(inputNumber);
        this.number = Integer.parseInt(inputNumber);
    }

    public int getNumber() {
        return number;
    }

    private void validateNumeric(String inputNumber) {
        if (!inputNumber.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 숫자로만 구성될 수 있습니다.");
        }
    }

    private void validateNumberInRange(String inputNumber) {
        if (Integer.parseInt(inputNumber) < MIN_NUMBER || Integer.parseInt(inputNumber) > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 부터 45 이내의 숫자중에 선택하여야됩니다.");
        }
    }


}
