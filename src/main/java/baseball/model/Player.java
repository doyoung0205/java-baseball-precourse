package baseball.model;

public class Player {

    /**
     * 콘솔로 부터 숫자를 입력받아 스윙을 합니다.
     *
     * @return 스윙 결과
     */
    public static SwingResult swingByBaseBall(final BaseBall baseBall) {


        // TODO 및 스윙 결과 메시지를 출력합니다.
        // BaseBallGameView.printSwingResult(swingResult);

        return null;
    }

    /**
     * 3스트라이크가 나올 때 까지 스윙을 반복적으로 수행합니다.
     */
    public static void swingByBaseBallRecursive(final BaseBall baseBall) {
        // TODO 플레이어가 투수가 던진 투구를 스윙 합니다.
        final SwingResult swingResult = Player.swingByBaseBall(baseBall);

        // TODO 3스트라이크인지 확인합니다.
        if (!swingResult.is3Strike()) {
            // 3스트라이크가 아니라면 다시 스윙을 합니다.
            swingByBaseBallRecursive(baseBall);
        }
    }

    /**
     * 콘솔로 부터 숫자를 입력받아 게임을 다시 시작할지 결정합니다.
     *
     * @return 재시작이면 true 아니면 false
     */
    public static boolean isReply() {
        return false;
    }
}
