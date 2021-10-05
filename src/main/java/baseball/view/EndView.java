package baseball.view;

public class EndView {

	private static final String END_GUIDE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

	/**
	 * 게임의 끝 인사를 콘솔에 출력합니다.
	 */
	public void resolve() {
		System.out.println(END_GUIDE_MESSAGE);
	}
}
