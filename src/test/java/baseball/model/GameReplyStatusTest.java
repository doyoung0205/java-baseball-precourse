package baseball.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("GameReplyStatus")
@DisplayName("GameReplyStatus 테스트")
public class GameReplyStatusTest {

	@Test
	void 재시작코드는_1이다() {
		// given
		final String stringCode = "1";
		// when
		final boolean isReply = GameReplyStatus.isReply(stringCode);
		// then
		assertTrue(isReply);
	}

	@ParameterizedTest(name = "문자열1이_아닌_경우는_재시작상태를_나타내지_않는다")
	@ValueSource(strings = {"2", "3", "10900000", "asdaskdas", "vfv", "∂∂∂∂∂"})
	void 문자열1이_아닌_경우는_재시작상태를_나타내지_않는다(final String stringCode) {
		// given
		// when
		final boolean isReply = GameReplyStatus.isReply(stringCode);
		// then
		assertFalse(isReply);
	}

	@Test
	void 재시작하지않는코드는_2이다() {
		// given
		final String stringCode = "2";
		// when
		final boolean isNotReply = GameReplyStatus.isNotReply(stringCode);
		// then
		assertTrue(isNotReply);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "3", "10900000", "asdaskdas", "vfv", "∂∂∂∂∂"})
	void 문자열2이_아닌_경우는_재시작이아닌상태를_나타내지_않는다(final String stringCode) {
		// given
		// when
		final boolean isReply = GameReplyStatus.isNotReply(stringCode);
		// then
		assertFalse(isReply);
	}
}
