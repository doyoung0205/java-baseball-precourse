package baseball.model.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.model.Player;
import baseball.model.exception.IllegalReplyInputValueException;

@Tag("Player")
@DisplayName("Player isReply 메서드 테스트")
public class PlayerIsReplyTest {
	private Player player;

	@BeforeEach
	void setUp() {
		player = new Player();
	}

	@Test
	void 재시작을하기_위해_1을_누르면_재시작이_가능하다() throws IllegalReplyInputValueException {
		// given
		final String replyOrNotInputValue = "1";
		// when
		final boolean reply = player.isReply(replyOrNotInputValue);
		// then
		assertTrue(reply);
	}

	@Test
	void 게임종료를_위해_2를_누르면_재시작이_불가능하다() throws IllegalReplyInputValueException {
		// given
		final String replyOrNotInputValue = "2";
		// when
		final boolean reply = player.isReply(replyOrNotInputValue);
		// then
		assertFalse(reply);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1212", "3", "-1", "가나다", "라", "", "´´", "¡"})
	void 입력시_1과_2를_제외하고_다른_입력이_들어오면_예외가_발생한다(final String replyOrNotInputValue) {
		// given
		// then
		assertThrows(IllegalReplyInputValueException.class, () -> {
			// when
			player.isReply(replyOrNotInputValue);
		});
	}
}
