import static org.junit.Assert.*;
import org.junit.Test;

public class partb {
    @Test
    public void path1_bothLoopsSkipped() {
        assertEquals(0, countSimilarWords.countSimilarWords("", "", 3));
    }
    @Test
    public void path2_firstLoopRunsNoAdds() {
        assertEquals(0, countSimilarWords.countSimilarWords("abc,def", "", 4));
    }
    @Test
    public void path3_someSetEntriesNoCount() {
        assertEquals(1, countSimilarWords.countSimilarWords("cat bat", "dog bat", 3));
    }
    @Test
    public void path4_positiveFullCount() {
        assertEquals(3, countSimilarWords.countSimilarWords("pen dog", "dog pen dog", 3));
    }
    @Test
    public void path5_secondLoopNoCompoundTrue() {
        assertEquals(0, countSimilarWords.countSimilarWords("one two", "three four", 3));
    }
}
