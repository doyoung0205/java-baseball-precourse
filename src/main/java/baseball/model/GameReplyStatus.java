package baseball.model;

public enum GameReplyStatus {

	REPLY("1"), NOT_REPLY("2");

	private final String code;

	GameReplyStatus(String code) {
		this.code = code;
	}

	public static boolean isReply(String stringCode) {
		return stringCode.equals(REPLY.code);
	}

	public static boolean isNotReply(String stringCode) {
		return stringCode.equals(NOT_REPLY.code);
	}
}


