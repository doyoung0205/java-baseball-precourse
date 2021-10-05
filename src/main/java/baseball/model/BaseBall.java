package baseball.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import baseball.model.exception.IllegalBaseBallArgumentException;
import nextstep.utils.Randoms;

public class BaseBall {

	private static final String FORMATION_REGEX =
		"^[" + BaseBallConstants.MIN_NUMBER + "-" + BaseBallConstants.MAX_NUMBER + "]{" + BaseBallConstants.SIZE + "}$";
	private final int[] baseball;

	private BaseBall(final int[] baseball) {
		this.baseball = baseball;
	}

	/**
	 * 정적 팩토리메서드 패턴을 이용해 <code>BaseBall</code> 객체를 생성해 반환합니다.
	 *
	 * @return {@link BaseBall}
	 */
	public static BaseBall getInstance() {
		final int[] baseBall = makeNewBaseBall();
		return new BaseBall(baseBall);
	}

	/**
	 * 문자열을 변환해 투구번호 생성합니다.
	 *
	 * @param textBaseBall 문자열로 이루어진 투구번호
	 * @return {@link BaseBall}
	 * @throws IllegalArgumentException 문자열이 1~9까지의 임의의수 3개가 아닐경우 발생합니다.
	 */
	public static BaseBall valueOf(final String textBaseBall) throws IllegalBaseBallArgumentException {
		validate(textBaseBall);
		final int[] digits = new int[textBaseBall.length()];
		for (int i = 0; i < textBaseBall.length(); i++) {
			digits[i] = Character.getNumericValue(textBaseBall.charAt(i));
		}

		return new BaseBall(digits);
	}

	/**
	 * 투구번호 배열에서 <code>number</code>가 있는지 확인합니다.
	 *
	 * @param number 확인하고자 하는 숫자
	 * @return {@link BaseBall#containsRecursive(int[], int, int, int)}
	 */
	public int indexOf(final int number) {
		return containsRecursive(this.baseball, number, 0, this.baseball.length - 1);
	}

	/**
	 * 현재 투구번호의 크기를 반환
	 */
	public int length() {
		return this.baseball.length;
	}

	/**
	 * 투구번호에서 <code>index</code> 인덱스의 가지고 있는 값을 반환합니다.
	 */
	public int getAt(final int index) {
		return this.baseball[index];
	}

	@Override
	public String toString() {
		return Arrays.toString(baseball);
	}

	/**
	 * 1~9 로 구성된 서로 다른 임의의 숫자 3개가 있는지 확인
	 *
	 * @param textBaseBall 문자열로 이루어진 투구번호
	 * @throws IllegalBaseBallArgumentException 문자열이 1~9까지의 임의의수 3개가 아닐경우 발생합니다.
	 */
	private static void validate(final String textBaseBall) throws IllegalBaseBallArgumentException {
		validateFormation(textBaseBall);
		validateSize(textBaseBall);
	}

	/**
	 * 1~9 로 구성된 서로 다른 임의의 숫자 3개가 있는지 확인
	 *
	 * @param textBaseBall 문자열로 이루어진 투구번호
	 * @throws IllegalBaseBallArgumentException 문자열이 1~9까지의 임의의수 3개가 아닐경우 발생합니다.
	 */
	private static void validateFormation(final String textBaseBall) throws IllegalBaseBallArgumentException {
		if (!textBaseBall.matches(FORMATION_REGEX)) {
			final String errorMsg = String.format("[ERROR] %s에서 %s 까지의 수 %s개를 입력해주세요. [%s]",
				BaseBallConstants.MIN_NUMBER, BaseBallConstants.MAX_NUMBER, BaseBallConstants.SIZE, textBaseBall);
			throw new IllegalBaseBallArgumentException(errorMsg);
		}
	}

	/**
	 * 1~9 로 구성된 서로 다른 임의의 숫자 3개가 있는지 확인
	 *
	 * @param textBaseBall 문자열로 이루어진 투구번호
	 * @throws IllegalBaseBallArgumentException 문자열이 1~9까지의 임의의수 3개가 아닐경우 발생합니다.
	 */
	private static void validateSize(final String textBaseBall) throws IllegalBaseBallArgumentException {
		final Set<Integer> numberSet = new HashSet<>();
		for (int i = 0; i < textBaseBall.length(); i++) {
			numberSet.add(Character.getNumericValue(textBaseBall.charAt(i)));
		}

		if (numberSet.size() != BaseBallConstants.SIZE) {
			throw new IllegalBaseBallArgumentException(
				String.format("[ERROR] 서로 다른 임의의 수를 입력해주세요. [%s]", textBaseBall));
		}
	}

	/**
	 * <code>BaseBallConstants.MAX_SIZE</code> 크기의
	 * <code>BaseBallConstants.MIN_NUMBER</code> 에서 <code>BaseBallConstants.MAX_NUMBER</code>
	 * 로 구성된 투구번호를 생성해 반환합니다.
	 *
	 * @return 투구번호
	 */
	private static int[] makeNewBaseBall() {
		final int[] baseBall = new int[BaseBallConstants.SIZE];
		int index = 0;
		while (baseBall[baseBall.length - 1] == 0) {
			final int pickNumber = Randoms.pickNumberInRange(BaseBallConstants.MIN_NUMBER,
				BaseBallConstants.MAX_NUMBER);
			index = addIfNotContains(baseBall, index, pickNumber);
		}

		return baseBall;
	}

	/**
	 * 추가하려는 숫자가 <code>baseBall</code> 배열의 존재하지 않을 경우 <br>
	 * <code>index</code> 번째 인덱스에 <code>pickNumber</code> 를 추가합니다.
	 *
	 * @param baseBall   투구번호가 들어가 있는 int 배열
	 * @param index      값을 추가하려는 배열의 인덱스
	 * @param pickNumber 추가하고자 하는 값
	 * @return 반환하는 값은 <code>baseBall</code> 배열의 추가가 된 경우는 기존에
	 * <code>index</code> 보다 +1 된 값을 반환하고 아닐 경우 기존 <code>index</code> 값을 반환합니다.
	 */
	private static int addIfNotContains(final int[] baseBall, final int index, final int pickNumber) {
		if (contains(baseBall, pickNumber, index)) {
			return index;
		}

		baseBall[index] = pickNumber;
		return index + 1;
	}

	/**
	 * 투구번호 배열에서 <code>number</code>가 있는지 확인합니다.
	 *
	 * @param baseBall 투구번호가 들어가 있는 int 배열
	 * @param number   확인하고자 하는 숫자
	 * @param range    확인하고자 하는 배열의 범위
	 * @return {Boolean} 있으면 True 없으면 false
	 */
	private static boolean contains(final int[] baseBall, final int number, final int range) {
		return containsRecursive(baseBall, number, 0, range) > -1;
	}

	/**
	 * <code>number</code>의 값을 찾을 때 까지 <code>start</code>의 값을 +1 하여 재귀적으로 함수를 실행합니다.
	 * <code>start</code> 의 값이 <code>end</code> 의 값보다 큰 경우 <code>baseBall</code> 배열의 존재하지 않는다는 것으로 간주합니다.
	 *
	 * @param baseBall 투구번호가 들어가 있는 int 배열
	 * @param number   확인하고자 하는 숫자
	 * @param start    탐색할 범위의 가장 처음 인덱스
	 * @param end      탐색할 범위의 가장 마지막 인덱스
	 * @return <code>number</code>의 값이 일치한 <code>baseBall</code> 배열 요소 중에 존재한다면 해당 요소의 인덱스를 반환하고 아닐 경우 -1 을 반환합니다.
	 */
	private static int containsRecursive(final int[] baseBall, final int number, final int start, final int end) {
		if (start > end) {
			return -1;
		}

		if (baseBall[start] == number) {
			return start;
		}

		return containsRecursive(baseBall, number, start + 1, end);
	}

}
