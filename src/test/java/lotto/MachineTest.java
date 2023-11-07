package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.models.Lotto;
import lotto.models.Machine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MachineTest {
    Machine machine = new Machine();
    @DisplayName("로또를 생성한다.")
    @Test
    void createLotto() {
        assertThat(machine.newLottery()).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또를 생성할 때 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void numbersHasDuplicated(){
        assertThatThrownBy(()-> machine.setNumbers(List.of(1,3,5,7,9,9), 10))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void bonusIsDuplicated() {
        assertThatThrownBy(()-> machine.setNumbers(List.of(1,3,5,7,9,11), 1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
