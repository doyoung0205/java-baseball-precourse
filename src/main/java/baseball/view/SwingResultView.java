package baseball.view;

import baseball.model.SwingResult;

public class SwingResultView {

	/**
	 * 스윙 결과 메시지를 콘솔에 출력합니다.
	 */
	public void resolve(final SwingResult swingResult) {
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

}
