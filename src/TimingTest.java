import org.junit.jupiter.api.Tag;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimingTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Circle.idCount = 0;
    }

    @Tag("score:30")
    @org.junit.jupiter.api.Test
    void TimeCompareTest() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(8273, 40000, 10000, 10000);
        BVH bvh = new BVH(circles);

        long startTimeBVH = System.nanoTime();
        HashSet<ContactResult> bvhContacts = ContactFinder.getContactsBVH(circles, bvh);
        long totalTimeBVH = System.nanoTime() - startTimeBVH;

        long startTimeNaive = System.nanoTime();
        HashSet<ContactResult> naiveContacts = ContactFinder.getContactsNaive(circles);
        long totalTimeNaive = System.nanoTime() - startTimeNaive;

        System.out.println("naive contact runtime in nanoseconds = " + totalTimeNaive);
        System.out.println("bvh contact runtime in nanoseconds = " + totalTimeBVH);
        System.out.println("naive contact-finder is " + totalTimeNaive/totalTimeBVH + " times slower than the bvh contact-finder");

        assertTrue(totalTimeBVH<totalTimeNaive/5);
        assertTrue(bvhContacts.equals(naiveContacts));
    }
}
