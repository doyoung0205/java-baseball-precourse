package baseball.model.exception;

/**
 * 잘못된 재시작 입력 값일 경우 발생합니다.
 *
 * @implNote 꼭 예외처리를 해야 하기에 CheckedException 을 사용
 */
public class IllegalReplyInputValueException extends Exception {

	private final String message;

	public IllegalReplyInputValueException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
