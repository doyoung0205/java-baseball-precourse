package baseball.controller;

import baseball.model.BaseBall;
import baseball.model.Pitcher;
import baseball.model.Player;
import baseball.model.SwingResult;
import baseball.view.BaseBallGameView;

public class BaseBallGameController {

    private final Pitcher pitcher;
    private final Player player;
    private final BaseBallGameView baseBallGameView;

    public BaseBallGameController() {
        this.pitcher = new Pitcher();
        this.player = new Player();
        this.baseBallGameView = new BaseBallGameView();
    }

    /**
     * 숫자 야구 게임을 시작합니다.
     */
    public void play() {

        // 투수가 던질 투구 번호를 고릅니다.
        final BaseBall baseBall = pitcher.pickBaseBall();
        System.out.println("투구 번호 :: " + baseBall);

        //  플레이어가 투수가 던진 투구를 스윙 합니다.
        swingByBaseBall(baseBall);

        // 게임의 끝 인사를 콘솔에 출력합니다.
        baseBallGameView.printEndMessage();
    }


    /**
     * @param baseBall 투구번호
     */
    private void swingByBaseBall(final BaseBall baseBall) {

        SwingResult swingResult = null;

        // 결과가 없거나 결과가 전부 스트라이크가 아닌 경우
        while (swingResult == null || !swingResult.isFullStrike()) {
            swingResult = player.swingByBaseBall(baseBall);
            baseBallGameView.printSwingResult(swingResult);
        }
    }

    /**
     * 플레이어가 게임을 다시 시작할지 결정합니다.
     */
    public boolean isReply() {
        return player.isReply();
    }
}
