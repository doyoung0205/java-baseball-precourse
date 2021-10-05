package baseball.model;

public class Player {

    /**
     * 콘솔로 부터 숫자를 입력받아 스윙을 하여 스윙 결과를 반환합니다.
     *
     * @return 스윙 결과
     */
    public SwingResult swingByBaseBall(final BaseBall baseBall, final String text) {

        final BaseBall expectedBaseBall = getExpectedBaseBallByExpectedText(text);

        return SwingResult.valueOf(baseBall, expectedBaseBall);
    }


    /**
     * 콘솔로 부터 숫자를 입력받아 게임을 다시 시작할지 결정합니다.
     *
     * @param isReplyFromConsoleInput 콘솔로 부터 입력받은 재시작 여부를 나타내는 텍스트
     * @return 재시작이면 true 아니면 false
     */
    public boolean isReply(final String isReplyFromConsoleInput) {

        if (isReplyFromConsoleInput.equals("1")) {
            return true;
        }

        if (isReplyFromConsoleInput.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] 잘못 입력하셨습니다. 1이나 2를 입력해주세요");
    }

    /**
     * 콘솔로 부터 입력받은 값으로 예상 투구번호를 반환합니다.
     */
    private BaseBall getExpectedBaseBallByExpectedText(final String expectedText) {

        try {
            return BaseBall.valueOf(expectedText);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return getExpectedBaseBallByExpectedText(expectedText);
    }
}
