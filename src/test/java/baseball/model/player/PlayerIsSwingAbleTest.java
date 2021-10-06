package baseball.model.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseBall;
import baseball.model.Player;
import baseball.model.SwingResult;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("Player")
@DisplayName("Player isSwingAble 메서드 테스트")
public class PlayerIsSwingAbleTest {
	private Player player;

	@BeforeEach
	void setUp() {
		player = new Player();
	}

	@Test
	void 스윙결과가_없다면_스윙을_수_있다() {
		// given
		final SwingResult swingResult = null;
		// when
		final boolean swingAble = player.isSwingAble(swingResult);
		// then
		assertTrue(swingAble);
	}

	@ParameterizedTest
	@CsvSource(value = {"175:574", "123:293", "749:419", "192:972"}, delimiterString = ":")
	void 스윙결과가_모두_스트라이크가_아니라면_스윙을_할_수_있다(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final boolean swingAble = player.isSwingAble(swingResult);
		// then
		assertTrue(swingAble);
	}

	@ParameterizedTest
	@CsvSource(value = {"175:175", "123:123", "749:749", "192:192"}, delimiterString = ":")
	void 스윙결과가_모두_스트라이크라면_스윙을_할_수_없다(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final boolean swingAble = player.isSwingAble(swingResult);
		// then
		assertFalse(swingAble);
	}

}
