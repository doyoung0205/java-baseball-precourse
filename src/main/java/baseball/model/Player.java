package baseball.model;

import baseball.view.BaseBallGameView;
import nextstep.utils.Console;

public class Player {

    /**
     * 콘솔로 부터 숫자를 입력받아 스윙을 하여 스윙 결과를 반환합니다.
     *
     * @return 스윙 결과
     */
    public SwingResult swingByBaseBall(final BaseBall baseBall) {

        final BaseBall expectedBaseBall = getExpectedBaseBallByConsoleInput();

        return SwingResult.valueOf(baseBall, expectedBaseBall);
    }


    /**
     * 콘솔로 부터 숫자를 입력받아 게임을 다시 시작할지 결정합니다.
     *
     * @return 재시작이면 true 아니면 false
     */
    public boolean isReply() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        final String expectedText = Console.readLine();
        if (expectedText.equals("1")) {
            return true;
        }

        if (expectedText.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] 잘못 입력하셨습니다. 1이나 2를 입력해주세요");
    }

    /**
     * 콘솔로 부터 입력받은 값으로 예상 투구번호를 반환합니다.
     */
    private BaseBall getExpectedBaseBallByConsoleInput() {

        System.out.print("숫자를 입력해 주세요 : ");
        final String expectedText = Console.readLine();

        try {
            return BaseBall.valueOf(expectedText);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return getExpectedBaseBallByConsoleInput();
    }
}
