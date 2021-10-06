package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseBall;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("BaseBall")
@DisplayName("BaseBall indexOf 메서드 테스트")
public class BaseBallIndexOfTest {

	// 값이 있는 경우
	@ParameterizedTest(name = "투구번호가_가지고있는_값의_인덱스_위치를_찾는_경우")
	@CsvSource(value = {"123:1:2:3", "143:1:4:3", "654:6:5:4", "378:3:7:8", "837:8:3:7"}, delimiterString = ":")
	void 투구번호가_가지고있는_값의_인덱스_위치를_찾는_경우(
		final String textBaseBall, final int numberAtIndex0, final int numberAtIndex1,
		final int numberAtIndex2) throws IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		// then
		assertAll(() -> {
			// when
			assertEquals(baseBall.indexOf(numberAtIndex0), 0);
			assertEquals(baseBall.indexOf(numberAtIndex1), 1);
			assertEquals(baseBall.indexOf(numberAtIndex2), 2);
		});
	}

	@ParameterizedTest(name = "투구번호가_가지고있지않은_값의_인덱스_위치를_찾는_경우")
	@CsvSource(value = {"123:5:4:9", "143:2:5:7", "654:1:2:3", "378:2:5:9", "837:2:1:4"}, delimiterString = ":")
	void 투구번호가_가지고있지않은_값의_인덱스_위치를_찾는_경우(
		final String textBaseBall, final int number1, final int number2,
		final int number3) throws IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		// then
		assertAll(() -> {
			// when
			assertEquals(baseBall.indexOf(number1), -1);
			assertEquals(baseBall.indexOf(number2), -1);
			assertEquals(baseBall.indexOf(number3), -1);
		});
	}
	// 값이 없는 경우
}
