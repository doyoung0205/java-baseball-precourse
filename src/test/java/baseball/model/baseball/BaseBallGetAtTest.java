package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import baseball.model.BaseBall;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("BaseBall")
@DisplayName("BaseBall getAt 메서드 테스트")
public class BaseBallGetAtTest {
	private BaseBall baseBall;

	@BeforeEach
	void setUp() throws IllegalBaseBallArgumentException {
		baseBall = BaseBall.valueOf("123");
	}

	@Test
	void 투구번호의_해당_인덱스_위치의_있는_값을_가져올_수_있다() {
		// given
		int valueAtZero = 1;
		int valueAtOne = 2;
		int valueAtTwo = 3;
		// when
		// then
		assertAll(() -> {
			assertEquals(baseBall.getAt(0), valueAtZero);
			assertEquals(baseBall.getAt(1), valueAtOne);
			assertEquals(baseBall.getAt(2), valueAtTwo);
		});
	}

	@Test
	void 투구번호의_크기보다_큰_인덱스값을_찾는_경우_예외발생() {
		// given
		int index = 4;
		// then
		assertThrows(IndexOutOfBoundsException.class, () -> {
			// when
			baseBall.getAt(index);
		});
	}
}
