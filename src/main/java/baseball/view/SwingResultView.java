package baseball.view;

import baseball.model.SwingResult;

public class SwingResultView {

	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String STRIKE_MESSAGE = "스트라이크 ";
	private static final String BALL_MESSAGE = "볼";

	/**
	 * 스윙 결과 메시지를 콘솔에 출력합니다.
	 */
	public void resolve(final SwingResult swingResult) {
		final StringBuilder resultMessage = new StringBuilder();
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		if (ballCount == 0 && strikeCount == 0) {
			System.out.println(NOTHING_MESSAGE);
			return;
		}
		if (strikeCount > 0) {
			resultMessage.append(strikeCount).append(STRIKE_MESSAGE);
		}
		if (ballCount > 0) {
			resultMessage.append(ballCount).append(BALL_MESSAGE);
		}
		System.out.println(resultMessage);
	}

}
