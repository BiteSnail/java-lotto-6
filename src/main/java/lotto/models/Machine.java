package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.configs.Constant;
import lotto.utils;

public class Machine{
    private Lotto lotto;
    private int bonus;
    public Machine(){
        this.lotto = null;
        this.bonus = 0;
    }
    public void setNumbers(Lotto lotto, int bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }
    public Lotto newLottery(){
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                    Constant.LOTTO_MIN_NUMBER,
                    Constant.LOTTO_MAX_NUMBER,
                    Constant.LOTTO_COUNT
                )
        );
    }

}
