package baseball.model.exception;

/**
 * 투구번호의 잘못된 매개변수가 확인되었을 때 발생합니다.
 *
 * @implNote 꼭 예외처리를 해야 하기에 CheckedException 을 사용
 */
public class IllegalBaseBallArgumentException extends Exception {

	private final String message;

	public IllegalBaseBallArgumentException(final String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
