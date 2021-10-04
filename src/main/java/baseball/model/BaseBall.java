package baseball.model;

import nextstep.utils.Randoms;

import java.util.Arrays;

public class BaseBall {

    private int[] baseball;

    private BaseBall(int[] baseball) {
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
     * <code>BaseBallConstants.MAX_SIZE</code> 크기의 <code>BaseBallConstants.MIN_NUMBER</code> 에서 <code>BaseBallConstants.MAX_NUMBER</code>
     * 로 구성된 투구번호를 생성해 반환합니다.
     *
     * @return 투구번호
     */
    private static int[] makeNewBaseBall() {

        final int[] baseBall = new int[BaseBallConstants.MAX_SIZE];

        int index = 0;
        while (baseBall[baseBall.length - 1] == 0) {

            final int pickNumber = Randoms.pickNumberInRange(BaseBallConstants.MIN_NUMBER, BaseBallConstants.MAX_NUMBER);

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
     * @return 반환하는 값은 <code>baseBall</code> 배열의 추가가 된 경우는 기존에 <code>index</code> 보다 +1 된 값을 반환하고 아닐 경우 기존 <code>index</code> 값을 반환합니다.
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
     * @return {@link BaseBall#containsRecursive(int[], int, int, int)}
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

    @Override
    public String toString() {
        return "BaseBall{" +
                "baseball=" + Arrays.toString(baseball) +
                '}';
    }
}
