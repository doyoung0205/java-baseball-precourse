package baseball;

import baseball.controller.BaseBallGameController;

public class Application {
    public static void main(String[] args) {

        // TODO 숫자 야구 게임 구현
        do {
            BaseBallGameController.play();
        } while (BaseBallGameController.isReply());

    }
}
