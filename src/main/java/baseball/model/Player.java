package baseball.model;

import baseball.model.exception.IllegalBaseBallArgumentException;
import baseball.model.exception.IllegalReplyInputValueException;

public class Player {

    /**
     * 텍스트를 예상 투구번호로 변환하여 투수의 베이스볼과 비교하여 스윙 결과를 반환합니다.
     *
     * @return 스윙 결과
     */
    public SwingResult swingByBaseBallAndExpectedText(final BaseBall baseBall, final String expectedText) {

        final BaseBall expectedBaseBall = getExpectedBaseBallByExpectedText(expectedText);

        return SwingResult.valueOf(baseBall, expectedBaseBall);
    }


    /**
     * 콘솔로 부터 숫자를 입력받아 게임을 다시 시작할지 결정합니다.
     *
     * @param replyOrNotInputValue 콘솔로 부터 입력받은 재시작 여부를 나타내는 텍스트
     * @return 재시작이면 true 아니면 false
     * @throws IllegalReplyInputValueException 잘못된 재시작 입력 값일 경우 발생합니다.
     */
    public boolean isReply(final String replyOrNotInputValue) throws IllegalReplyInputValueException {

        if (GameReplyStatus.isReply(replyOrNotInputValue)) {
            return true;
        }

        if (GameReplyStatus.isNotReply(replyOrNotInputValue)) {
            return false;
        }

        throw new IllegalReplyInputValueException("[ERROR] 잘못 입력하셨습니다. 1이나 2를 입력해주세요");
    }


    /**
     * 스윙을 할 수 있다면 True 없다면 False 를 반환합니다.
     *
     * @param swingResult 스윙 결과
     * @return 스윙결과가 모두 스트라이크가 아니거나 스윙결과가 없으면 True 를 반환 아니면 False 반환
     */
    public boolean isSwingAble(final SwingResult swingResult) {
        return swingResult == null || !swingResult.isFullStrike();
    }

    /**
     * 콘솔로 부터 입력받은 값으로 예상 투구번호를 반환합니다.
     */
    private BaseBall getExpectedBaseBallByExpectedText(final String expectedText) {

        try {
            return BaseBall.valueOf(expectedText);
        } catch (IllegalBaseBallArgumentException e) {
            System.out.println(e.getMessage());
        }

        return getExpectedBaseBallByExpectedText(expectedText);
    }
}
