package baseball.model;

public class SwingResult {

	private final int ballCount;
	private final int strikeCount;

	private SwingResult(int ballCount, int strikeCount) {
		this.ballCount = ballCount;
		this.strikeCount = strikeCount;
	}

	/**
	 * 스윙 결과 를 반환합니다.
	 *
	 * @param baseBall         투구번호
	 * @param expectedBaseBall 예상투구번호
	 * @return {@link SwingResult}
	 * @throws IllegalArgumentException Null 인 경우 발생합니다.
	 */
	public static SwingResult valueOf(final BaseBall baseBall, final BaseBall expectedBaseBall) {
		validate(baseBall, expectedBaseBall);
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < expectedBaseBall.length(); i++) {
			final int expectedNumber = expectedBaseBall.getAt(i);
			strikeCount = countUpIfStrike(baseBall, expectedNumber, i, strikeCount);
			ballCount = countUpIfBall(baseBall, expectedNumber, i, ballCount);
		}

		return new SwingResult(ballCount, strikeCount);
	}

	/**
	 * 전부 스트라이크 이면 True 를 반환합니다.
	 */
	public boolean isFullStrike() {
		return this.strikeCount == BaseBallConstants.SIZE;
	}

	/**
	 * 투구번호와 예상투구번호가 NULL 이 아닌지 유효성 검사를 합니다.
	 *
	 * @param baseBall         투구번호
	 * @param expectedBaseBall 예상투구번호
	 * @throws IllegalArgumentException Null 인 경우 발생합니다.
	 */
	private static void validate(final BaseBall baseBall, final BaseBall expectedBaseBall) {
		if (baseBall == null) {
			throw new IllegalArgumentException("baseBall 이 무조건 존재해야 합니다.");
		}

		if (expectedBaseBall == null) {
			throw new IllegalArgumentException("expectedBaseBall 이 무조건 존재해야 합니다.");
		}
	}

	/**
	 * <code>expectedNumber</code> 값이 <code>baseBall</code>의 <code>bIndex</code> 인덱스 위치의
	 * 존재하지 않으면서 다른 위치에 존재할 경우 <code>ballCount</code> 를 증가하여 반환합니다.
	 *
	 * @param baseBall       투구번호
	 * @param expectedNumber 예상숫자
	 * @param bIndex         투구번호의 인덱스
	 * @param ballCount      볼 갯수
	 * @return 볼일 경우에 <code>ballCount</code> 에 +1 하여 반환하고 아닌 경우 그대로 반환합니다.
	 */
	private static int countUpIfBall(
			final BaseBall baseBall, final int expectedNumber, final int bIndex, final int ballCount) {

		final int index = baseBall.indexOf(expectedNumber);
		if (index != bIndex && index > -1) {
			return ballCount + 1;
		}

		return ballCount;
	}

	/**
	 * <code>expectedNumber</code> 값이 <code>baseBall</code>의 <code>bIndex</code>
	 * 인덱스 위치에 존재할 경우 <code>strikeCount</code> 를 증가하여 반환합니다.
	 *
	 * @param baseBall       투구번호
	 * @param expectedNumber 예상숫자
	 * @param bIndex         투구번호의 인덱스
	 * @param strikeCount    스트라이크 갯수
	 * @return 스트라이크인 경우에 <code>strikeCount</code> 에 +1 하여 반환하고 아닌 경우 그대로 반환합니다.
	 */
	private static int countUpIfStrike(
			final BaseBall baseBall, final int expectedNumber, final int bIndex, final int strikeCount) {

		final int index = baseBall.indexOf(expectedNumber);
		if (index == bIndex && index > -1) {
			return strikeCount + 1;
		}

		return strikeCount;
	}

	@Override
	public String toString() {
		return "SwingResult{"
				+ "ballCount=" + ballCount
				+ ", strikeCount=" + strikeCount
				+ '}';
	}

	public int getBallCount() {
		return this.ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}
}
