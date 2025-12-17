import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class partc {
    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("", "", 3, 0),
                Arguments.of("abc,def", "", 4, 0),
                Arguments.of("cat bat", "dog bat", 3, 1),
                Arguments.of("pen dog", "dog pen dog", 3, 3),
                Arguments.of("one two", "three four", 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void testAllPaths(String str1, String str2, int length, int expected) {
        assertEquals(expected, countSimilarWords.countSimilarWords(str1, str2, length));
    }
}
