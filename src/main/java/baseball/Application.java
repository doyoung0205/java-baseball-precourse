package baseball;

import baseball.controller.BaseBallGameController;

public class Application {
    public static void main(String[] args) {
        // 숫자 야구 게임 구현
        final BaseBallGameController baseBallGameController = new BaseBallGameController();

        do {
            baseBallGameController.play();
        } while (baseBallGameController.isReply());

    }
}
