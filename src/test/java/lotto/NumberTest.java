package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "20", "30", "45"})
    @DisplayName("로또 번호에 정상적인 값을 입력했을 경우 테스트 성공한다.")
    void lottoNumberTest_1(String number) {
        assertThatNoException().isThrownBy(() -> new Number(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  1", "1  ", "ABC", "1ABC", "ABC1"})
    @DisplayName("로또 번호에 문자가 포함되어있으면 예외가 발생한다.")
    void lottoNumberTest_2(String number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또번호는 숫자로만 구성될 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    @DisplayName("로또 번호에 범위를 벗어났을 경우 예외가 발생한다.")
    void lottoNumberTest_3(String number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1 부터 45 이내의 숫자중에 선택하여야됩니다.");
    }


}