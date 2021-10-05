package baseball.model;

import baseball.view.BaseBallGameView;
import nextstep.utils.Console;

public class Player {

    /**
     * 콘솔로 부터 숫자를 입력받아 스윙을 합니다.
     *
     * @return 스윙 결과
     */
    public static SwingResult swingByBaseBall(final BaseBall baseBall) {

        final BaseBall expectedBaseBall = getExpectedBaseBallByConsoleInput();
        final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);

        // 스윙 및 스윙 결과 메시지를 출력합니다.
        BaseBallGameView.printSwingResult(swingResult);

        return swingResult;
    }


    /**
     * 전부 스트라이크가 나올 때 까지 스윙을 반복적으로 수행합니다.
     */
    public static void swingByBaseBallRecursive(final BaseBall baseBall) {
        //  플레이어가 투수가 던진 투구를 스윙 합니다.
        final SwingResult swingResult = Player.swingByBaseBall(baseBall);

        //  전부 스트라이크인지 확인합니다.
        if (!swingResult.isFullStrike()) {
            // 전부 스트라이크가 아니라면 다시 스윙을 합니다.
            swingByBaseBallRecursive(baseBall);
        }
    }

    /**
     * 콘솔로 부터 숫자를 입력받아 게임을 다시 시작할지 결정합니다.
     *
     * @return 재시작이면 true 아니면 false
     */
    public static boolean isReply() {
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
    private static BaseBall getExpectedBaseBallByConsoleInput() {

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
