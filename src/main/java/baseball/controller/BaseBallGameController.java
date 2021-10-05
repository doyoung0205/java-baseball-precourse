package baseball.controller;

import baseball.model.BaseBall;
import baseball.model.Pitcher;
import baseball.model.Player;
import baseball.model.SwingResult;
import baseball.view.ConsoleInputView;
import baseball.view.EndView;
import baseball.view.SwingResultView;

public class BaseBallGameController {

    private final Pitcher pitcher;
    private final Player player;
    private final SwingResultView swingResultView;
    private final EndView endView;
    private final ConsoleInputView consoleView;

    public BaseBallGameController() {
        this.pitcher = new Pitcher();
        this.player = new Player();
        this.swingResultView = new SwingResultView();
        this.endView = new EndView();
        this.consoleView = new ConsoleInputView();
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
        endView.resolve();
    }


    /**
     * @param baseBall 투구번호
     */
    private void swingByBaseBall(final BaseBall baseBall) {

        SwingResult swingResult = null;

        // 결과가 없거나 결과가 전부 스트라이크가 아닌 경우
        while (swingResult == null || !swingResult.isFullStrike()) {

            final String expectedText = consoleView.getExpectedNumberInputValue();

            swingResult = player.swingByBaseBall(baseBall, expectedText);

            swingResultView.resolve(swingResult);
        }
    }

    /**
     * 플레이어가 게임을 다시 시작할지 결정합니다.
     */
    public boolean isReply() {

        final String replyOrNotInputValue = consoleView.getReplyOrNotInputValue();

        try {
            return player.isReply(replyOrNotInputValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return isReply();
    }
}
