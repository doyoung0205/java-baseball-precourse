package baseball.controller;

import baseball.model.BaseBall;
import baseball.model.Pitcher;
import baseball.model.Player;
import baseball.view.BaseBallGameView;

public class BaseBallGameController {

    /**
     * 숫자 야구 게임을 시작합니다.
     */
    public static void play() {

        // 투수가 던질 투구 번호를 고릅니다.
        final BaseBall baseBall = Pitcher.pickBaseBall();

        // TODO 플레이어가 투수가 던진 투구를 스윙 합니다.
        Player.swingByBaseBallRecursive(baseBall);

        // TODO 게임의 끝 인사를 콘솔에 출력합니다.
        BaseBallGameView.printEndMessage();
    }

    /**
     * 플레이어가 게임을 다시 시작할지 결정합니다.
     */
    public static boolean isReply() {
        return Player.isReply();
    }
}
