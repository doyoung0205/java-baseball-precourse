package baseball.controller;

import baseball.model.BaseBall;
import baseball.model.Pitcher;
import baseball.model.Player;
import baseball.model.SwingResult;
import baseball.model.exception.IllegalBaseBallArgumentException;
import baseball.model.exception.IllegalReplyInputValueException;
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
		// 투수가 투구번호 골라 던집니다.
		final BaseBall baseBall = pitcher.pickBaseBall();
		// System.out.println("투구 번호 :: " + baseBall);
		// 투수가 던진 투구를 스윙 합니다.
		swingByBaseBall(baseBall);
		// 게임의 끝 인사를 콘솔에 출력합니다.
		endView.resolve();
	}

	/**
	 * 스윙 결과가 전부 스트라이크일 경우가 아니라면 계속 플레이어가 스윙을 합니다.
	 *
	 * @param baseBall 투구번호
	 */
	private void swingByBaseBall(final BaseBall baseBall) {
		SwingResult swingResult = null;
		// 플레이어가 스윙을 할 수 있는지 확인 후 할 수 있을 때 까지 스윙
		while (player.isSwingAble(swingResult)) {
			swingResult = swingByBaseBallRecursive(baseBall);
		}
	}

	/**
	 * 플레이어가 게임을 다시 시작할지 결정합니다.
	 */
	public boolean isReply() {
		final String replyOrNotInputValue = consoleView.getReplyOrNotInputValue();
		try {
			return player.isReply(replyOrNotInputValue);
		} catch (final IllegalReplyInputValueException exception) {
			System.out.println(exception.getMessage());
		}
		return isReply();
	}

	/**
	 * 콘솔로 부터 예상 번호를 입력받아 플페이어가 스윙을 하여 결과를 조회합니다.
	 *
	 * @param baseBall 투구번호
	 * @return 스윙 결과를 반환합니다.
	 */
	private SwingResult swingByBaseBallRecursive(final BaseBall baseBall) {
		final String expectedText = consoleView.getExpectedNumberInputValue();
		try {
			final SwingResult swingResult = player.swingByBaseBallAndExpectedText(baseBall, expectedText);
			swingResultView.resolve(swingResult);
			return swingResult;
		} catch (final IllegalBaseBallArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		return swingByBaseBallRecursive(baseBall);
	}

}
