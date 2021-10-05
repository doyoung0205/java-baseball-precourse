package baseball.view;

import nextstep.utils.Console;

public class ConsoleInputView {

	private static final String REPLY_GUIDE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String EXPECTED_NUMBER_GUIDE_MESSAGE = "숫자를 입력해 주세요 : ";

	/**
	 * 콘솔로 부터 게임을 재시작 여부를 입력받은 내용을 반환합니다.
	 */
	public String getReplyOrNotInputValue() {
		System.out.println(REPLY_GUIDE_MESSAGE);
		return Console.readLine();
	}

	/**
	 * 콘솔로 부터 예상 숫자를 입력받은 내용을 반환합니다.
	 */
	public String getExpectedNumberInputValue() {
		System.out.print(EXPECTED_NUMBER_GUIDE_MESSAGE);
		return Console.readLine();
	}
}
