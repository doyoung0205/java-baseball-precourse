package baseball.view;

import baseball.model.SwingResult;

public class BaseBallGameView {

    /**
     * TODO 스윙 결과 메시지를 콘솔에 출력합니다.
     */
    public static void printSwingResult(final SwingResult swingResult) {
        final StringBuilder resultMessage = new StringBuilder();

        final int strikeCount = swingResult.getStrikeCount();
        final int ballCount = swingResult.getBallCount();

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strikeCount > 0) {
            resultMessage.append(strikeCount).append("스트라이크 ");
        }

        if (ballCount > 0) {
            resultMessage.append(ballCount).append("볼");
        }

        System.out.println(resultMessage);
    }

    /**
     * TODO 게임의 끝 인사를 콘솔에 출력합니다.
     */
    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
