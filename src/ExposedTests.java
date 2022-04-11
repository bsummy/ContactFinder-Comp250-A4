import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ExposedTests {
    String[] sharedSolutions1 = new String[]{
            "Contact between circles: Circle(id: 3, position: vec2(110.708802400862, 159.1488822272439), radius: 10.0) and Circle(id: 19, position: vec2(105.55895901168735, 175.38329517055791), radius: 10.0)",
            "Contact between circles: Circle(id: 4, position: vec2(178.83451943789385, 195.10987511675026), radius: 10.0) and Circle(id: 6, position: vec2(166.80090785897286, 183.01788333968273), radius: 10.0)",
            "Contact between circles: Circle(id: 5, position: vec2(31.78290061988751, 9.159829106489958), radius: 10.0) and Circle(id: 10, position: vec2(31.686015043105485, 20.30268256485568), radius: 10.0)",
            "Contact between circles: Circle(id: 6, position: vec2(166.80090785897286, 183.01788333968273), radius: 10.0) and Circle(id: 8, position: vec2(155.8708241451029, 173.83556561458593), radius: 10.0)",
            "Contact between circles: Circle(id: 7, position: vec2(109.57325917373406, 194.72954771307963), radius: 10.0) and Circle(id: 16, position: vec2(99.90144323128585, 194.5904770777385), radius: 10.0)",
            "Contact between circles: Circle(id: 7, position: vec2(109.57325917373406, 194.72954771307963), radius: 10.0) and Circle(id: 19, position: vec2(105.55895901168735, 175.38329517055791), radius: 10.0)",
            "Contact between circles: Circle(id: 9, position: vec2(18.112050552055848, 143.3385760077638), radius: 10.0) and Circle(id: 14, position: vec2(10.300063871654096, 156.07456982003097), radius: 10.0)",
    };
    String[] sharedSolutions2 = new String[]{
            "Contact between circles: Circle(id: 0, position: vec2(711.2630723664405, 596.8061924672953), radius: 10.0) and Circle(id: 131, position: vec2(727.3466861363936, 593.9276720366443), radius: 10.0)",
            "Contact between circles: Circle(id: 102, position: vec2(54.2498125089697, 22.993099297230856), radius: 10.0) and Circle(id: 132, position: vec2(53.584095536187974, 28.283450765785133), radius: 10.0)",
            "Contact between circles: Circle(id: 11, position: vec2(794.3010821534705, 247.78607500529145), radius: 10.0) and Circle(id: 42, position: vec2(777.028356664689, 256.84699401307523), radius: 10.0)",
            "Contact between circles: Circle(id: 11, position: vec2(794.3010821534705, 247.78607500529145), radius: 10.0) and Circle(id: 71, position: vec2(794.2610134428334, 236.00423444409827), radius: 10.0)",
            "Contact between circles: Circle(id: 113, position: vec2(22.02517753282791, 203.25517041702653), radius: 10.0) and Circle(id: 139, position: vec2(5.186486814966074, 197.5506139514455), radius: 10.0)",
            "Contact between circles: Circle(id: 114, position: vec2(54.39790010131347, 305.1338326754371), radius: 10.0) and Circle(id: 135, position: vec2(66.04939837004373, 304.3692374296035), radius: 10.0)",
            "Contact between circles: Circle(id: 139, position: vec2(5.186486814966074, 197.5506139514455), radius: 10.0) and Circle(id: 149, position: vec2(5.7919783495308685, 182.64822365120202), radius: 10.0)",
            "Contact between circles: Circle(id: 24, position: vec2(647.1593521247386, 428.5726049503637), radius: 10.0) and Circle(id: 105, position: vec2(640.6634915617419, 420.20902286260497), radius: 10.0)",
            "Contact between circles: Circle(id: 26, position: vec2(509.16480044370485, 522.8433294146076), radius: 10.0) and Circle(id: 82, position: vec2(503.5774784447848, 505.8657254022185), radius: 10.0)",
            "Contact between circles: Circle(id: 29, position: vec2(434.10753563836596, 194.07423672686355), radius: 10.0) and Circle(id: 107, position: vec2(419.49559629301837, 183.7770621550379), radius: 10.0)",
            "Contact between circles: Circle(id: 3, position: vec2(244.08960301732316, 220.64120222599638), radius: 10.0) and Circle(id: 61, position: vec2(252.74752961966217, 209.7314697614856), radius: 10.0)",
            "Contact between circles: Circle(id: 30, position: vec2(167.7105560725301, 192.61892599638654), radius: 10.0) and Circle(id: 58, position: vec2(177.18899938168465, 192.24958531096703), radius: 10.0)",
            "Contact between circles: Circle(id: 4, position: vec2(669.8428384653567, 177.64211355878362), radius: 10.0) and Circle(id: 35, position: vec2(670.9111754271127, 173.855585267484), radius: 10.0)",
            "Contact between circles: Circle(id: 4, position: vec2(669.8428384653567, 177.64211355878362), radius: 10.0) and Circle(id: 7, position: vec2(688.3950888847409, 172.7714319491339), radius: 10.0)",
            "Contact between circles: Circle(id: 50, position: vec2(725.651570278235, 182.37035597206773), radius: 10.0) and Circle(id: 115, position: vec2(733.647677195008, 172.3804443728661), radius: 10.0)",
            "Contact between circles: Circle(id: 54, position: vec2(443.0006715069804, 26.692819565503), radius: 10.0) and Circle(id: 103, position: vec2(433.13711838631724, 40.581365822468186), radius: 10.0)",
            "Contact between circles: Circle(id: 59, position: vec2(90.04798818372785, 208.5273203457128), radius: 10.0) and Circle(id: 64, position: vec2(81.07472352712905, 225.3595241129624), radius: 10.0)",
            "Contact between circles: Circle(id: 6, position: vec2(710.2817898882234, 56.96564619266154), radius: 10.0) and Circle(id: 13, position: vec2(720.57840417561, 51.828925971386376), radius: 10.0)",
            "Contact between circles: Circle(id: 7, position: vec2(688.3950888847409, 172.7714319491339), radius: 10.0) and Circle(id: 35, position: vec2(670.9111754271127, 173.855585267484), radius: 10.0)",
            "Contact between circles: Circle(id: 77, position: vec2(556.3572319058319, 495.21004104694947), radius: 10.0) and Circle(id: 108, position: vec2(556.3106430703058, 485.98709088119654), radius: 10.0)",
            "Contact between circles: Circle(id: 82, position: vec2(503.5774784447848, 505.8657254022185), radius: 10.0) and Circle(id: 124, position: vec2(496.39908337089827, 503.67174111124547), radius: 10.0)",
            "Contact between circles: Circle(id: 9, position: vec2(751.5975838862607, 171.81645288394566), radius: 10.0) and Circle(id: 115, position: vec2(733.647677195008, 172.3804443728661), radius: 10.0)",
    };

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Circle.idCount = 0;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    // NAIVE CONTACT TESTS BELOW

    // Tests that a lone circle doesn't contact itself
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void NaiveSelfContactTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));

        HashSet<ContactResult> res = ContactFinder.getContactsNaive(circles);
        assertEquals(0, res.size());
    }

    // Tests that contact is detected between two circles in the same location
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void NaiveSimpleContactTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(0,0), 10));

        HashSet<ContactResult> res = ContactFinder.getContactsNaive(circles);

        assertEquals(1, res.size());
        assertTrue(res.contains(new ContactResult(circles.get(0), circles.get(1))));
    }

    // Tests that contacts are corrected generated for 3 circles in contact at the same location
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void NaiveSimpleContactTest2() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(0,0), 10));

        HashSet<ContactResult> res = ContactFinder.getContactsNaive(circles);

        assertEquals(3, res.size());
        assertTrue(res.contains(new ContactResult(circles.get(0), circles.get(1))));
        assertTrue(res.contains(new ContactResult(circles.get(0), circles.get(2))));
        assertTrue(res.contains(new ContactResult(circles.get(1), circles.get(2))));
    }

    // Tests that two circles which are not in contact generate no contacts
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void NaiveNonContactTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(30,0), 10));

        HashSet<ContactResult> res = ContactFinder.getContactsNaive(circles);

        assertEquals(0, res.size());
    }

    // Tests contacts between 20 circles in deterministically pseudorandom positions
    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void NaiveContactTest1() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(8923, 20, 200, 200);
        HashSet<ContactResult> res = ContactFinder.getContactsNaive(circles);
        ArrayList<String> resString = PublicTesterUtils.serializeContactResultList(res);
        assertEquals(sharedSolutions1.length, resString.size());
        for (int i = 0; i < resString.size(); i++) {
            if(!sharedSolutions1[i].equals(resString.get(i))){
                fail("Contact results are not correct! To see why, replace the contents of Visualizer.initScene() with \"circles = Utils.randomInit(8923, 20, 200, 200);\"");
            }
        }
    }


    // Tests contacts between 150 circles in deterministically pseudorandom positions
    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void NaiveContactTest2() {
        int radius=5;
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(2879, 150, 800, 600);
        HashSet<ContactResult> res = ContactFinder.getContactsNaive(circles);
        ArrayList<String> resString = PublicTesterUtils.serializeContactResultList(res);
        assertEquals(sharedSolutions2.length, resString.size());
        for (int i = 0; i < resString.size(); i++) {
            if(!sharedSolutions2[i].equals(resString.get(i))){
                fail("Contact results are not correct! To see why, replace the contents of Visualizer.initScene() with \"circles = Utils.randomInit(2879, 150, 800, 600);\"");
            }
        }
    }

    // getContactsBVH TESTS BELOW

    // Tests that a lone circle doesn't contact itself
    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void BVHSelfContactTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(60,0), 10));
        BVH bvh=new BVH(circles);
        HashSet<ContactResult> res = ContactFinder.getContactsBVH(circles, bvh);
        assertEquals(0, res.size());
    }

    // Tests that contact is detected between two circles
    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void BVHSimpleContactTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0, 0), 10));
        circles.add(new Circle(new Vector2(5,0), 10));

        BVH bvh=new BVH(circles);
        HashSet<ContactResult> res = ContactFinder.getContactsBVH(circles, bvh);

        assertEquals(1, res.size());
        assertTrue(res.contains(new ContactResult(circles.get(0), circles.get(1))));
    }

    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void BVHNoncontactTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(40,0), 10));
        BVH bvh=new BVH(circles);
        HashSet<ContactResult> res = ContactFinder.getContactsBVH(circles, bvh);
        assertEquals(0, res.size());
    }

    @Tag("score:4")
    @org.junit.jupiter.api.Test
    void BVHContactTest1() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(8923, 20, 200, 200);
        BVH bvh=new BVH(circles);
        HashSet<ContactResult> res = ContactFinder.getContactsBVH(circles, bvh);
        ArrayList<String> resString = PublicTesterUtils.serializeContactResultList(res);
        assertEquals(sharedSolutions1.length, resString.size());
        for (int i = 0; i < resString.size(); i++) {
            if(!sharedSolutions1[i].equals(resString.get(i))){
                fail("Contact results are not correct! To see why, replace the contents of Visualizer.initScene() with \"circles = Utils.randomInit(8923, 20, 200, 200);\"");
            }
        }
    }

    @Tag("score:4")
    @org.junit.jupiter.api.Test
    void BVHContactTest2() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(2879, 150, 800, 600);
        BVH bvh=new BVH(circles);
        HashSet<ContactResult> res = ContactFinder.getContactsBVH(circles, bvh);
        ArrayList<String> resString = PublicTesterUtils.serializeContactResultList(res);
        assertEquals(sharedSolutions2.length, resString.size());
        for (int i = 0; i < resString.size(); i++) {
            if(!sharedSolutions2[i].equals(resString.get(i))){
                fail("Contact results are not correct! To see why, replace the contents of Visualizer.initScene() with \"circles = Utils.randomInit(2879, 150, 800, 600);\"");
            }
        }
    }

    // BVH STRUCTURE TESTS BELOW

    // This test checks whether every circle in the original list was placed somewhere in the bvh
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHContainsAllCirclesTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(20,0), 10));

        BVH bvh = new BVH(circles);
        assertTrue(PublicTesterUtils.containsAllCircles(circles, bvh));
    }

    // This test checks whether every circle in the original list was placed somewhere in the bvh
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHContainsAllCirclesTest2() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(30,30), 10));
        circles.add(new Circle(new Vector2(40,40), 10));
        circles.add(new Circle(new Vector2(20,0), 10));
        circles.add(new Circle(new Vector2(5,-10), 10));
        circles.add(new Circle(new Vector2(-10,-30), 10));

        BVH bvh = new BVH(circles);
        assertTrue(PublicTesterUtils.containsAllCircles(circles, bvh));
    }

    // Tests to see if child boundingboxes are fully enclosed in their parent for a very simple bvh
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHChildrenContainedInParentsTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(30,30), 10));

        BVH bvh = new BVH(circles);

        assertTrue(bvh != null);
        assertEquals(2, PublicTesterUtils.weight(bvh));
        assertTrue(PublicTesterUtils.childrenInsideParents(bvh));
    }

    // Tests to see if child boundingboxes are fully enclosed in their parent for a more complicated simple bvh
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHChildrenContainedInParentsTest2() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(30,30), 10));
        circles.add(new Circle(new Vector2(40,40), 10));
        circles.add(new Circle(new Vector2(20,0), 10));
        circles.add(new Circle(new Vector2(5,-10), 10));
        circles.add(new Circle(new Vector2(-10,-30), 10));

        BVH bvh = new BVH(circles);

        assertTrue(bvh != null);
        assertEquals(6, PublicTesterUtils.weight(bvh));
        assertTrue(PublicTesterUtils.childrenInsideParents(bvh));
    }

    // This test checks two things
    // 1. That ONLY the leaves of your BVH have containedCircles
    // 2. That ALL the leaves of your BVH have containedCircles
    // Read carefully, these are not the same thing
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHCirclesInLeavesTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(20,0), 10));

        BVH bvh = new BVH(circles);
        assertTrue(PublicTesterUtils.areCirclesInLeaves(bvh));
    }

    // This test checks two things
    // 1. That ONLY the leaves of your BVH have containedCircles
    // 2. That ALL the leaves of your BVH have containedCircles
    // Read carefully, these are not the same thing
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHCirclesInLeavesTest2() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(30,30), 10));
        circles.add(new Circle(new Vector2(40,40), 10));
        circles.add(new Circle(new Vector2(20,0), 10));
        circles.add(new Circle(new Vector2(5,-10), 10));
        circles.add(new Circle(new Vector2(-10,-30), 10));

        BVH bvh = new BVH(circles);

        assertTrue(bvh != null);
        assertTrue(PublicTesterUtils.areCirclesInLeaves(bvh));
    }

    // Checks if a very simple bvh is correctly balanced by weight / number of circles per child
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHWeightTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(20,0), 10));

        BVH bvh = new BVH(circles);

        assertTrue(bvh != null);
        assertTrue(bvh.child1 != null);
        assertTrue(bvh.child2 != null);
        assertEquals(2, PublicTesterUtils.weight(bvh));
        assertEquals(1, PublicTesterUtils.weight(bvh.child1));
        assertEquals(1, PublicTesterUtils.weight(bvh.child2));
    }

    // Checks if a slightly more complicated bvh is correctly balanced by weight / number of circles per child
    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void BVHWeightTest2() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(20,0), 10));
        circles.add(new Circle(new Vector2(40,0), 10));
        circles.add(new Circle(new Vector2(60,0), 10));

        BVH bvh = new BVH(circles);

        assertTrue(bvh != null);
        assertTrue(bvh.child1 != null);
        assertTrue(bvh.child2 != null);
        assertEquals(4, PublicTesterUtils.weight(bvh));
        assertEquals(2, PublicTesterUtils.weight(bvh.child1));
        assertEquals(2, PublicTesterUtils.weight(bvh.child2));
        assertTrue(bvh.child1.child1 != null);
        assertTrue(bvh.child1.child2 != null);
        assertTrue(bvh.child2.child1 != null);
        assertTrue(bvh.child2.child2 != null);
        assertEquals(1, PublicTesterUtils.weight(bvh.child1.child1));
        assertEquals(1, PublicTesterUtils.weight(bvh.child1.child2));
        assertEquals(1, PublicTesterUtils.weight(bvh.child2.child1));
        assertEquals(1, PublicTesterUtils.weight(bvh.child2.child2));
    }

    // An aggregate test that checks if
    // 1. All given circles made it into the bvh
    // 2. All the circles in the bvh are at the leaves
    // 3. Only the given circles made it into the bvh, nothing more
    // 4. All child boundingBoxes are contained within their parents boundingBoxes
    @Tag("score:4")
    @org.junit.jupiter.api.Test
    void BVHCorrectnessTest() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(new Vector2(0,0), 10));
        circles.add(new Circle(new Vector2(30,30), 10));
        circles.add(new Circle(new Vector2(40,40), 10));
        circles.add(new Circle(new Vector2(20,0), 10));
        circles.add(new Circle(new Vector2(5,-10), 10));
        circles.add(new Circle(new Vector2(-10,-30), 10));

        BVH bvh = new BVH(circles);

        assertTrue(bvh != null);
        assertEquals(6, PublicTesterUtils.weight(bvh));
        assertTrue(PublicTesterUtils.containsAllCircles(circles, bvh));
        assertTrue(PublicTesterUtils.areCirclesInLeaves(bvh));
        assertTrue(PublicTesterUtils.childrenInsideParents(bvh));
        assertTrue(PublicTesterUtils.leavesMinimumSize(bvh, 9.99f));
    }

    // An aggregate test that checks if
    // 1. All given circles made it into the bvh
    // 2. All the circles in the bvh are at the leaves
    // 3. Only the given circles made it into the bvh, nothing more
    // 4. All child boundingBoxes are contained within their parents boundingBoxes
    @Tag("score:4")
    @org.junit.jupiter.api.Test
    void BVHCorrectnessTest2() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(0, 100, 1000, 1000);
        BVH bvh = new BVH(circles);

        assertTrue(bvh != null);
        assertEquals(100, PublicTesterUtils.weight(bvh));
        assertTrue(PublicTesterUtils.containsAllCircles(circles, bvh));
        assertTrue(PublicTesterUtils.areCirclesInLeaves(bvh));
        assertTrue(PublicTesterUtils.childrenInsideParents(bvh));
        assertTrue(PublicTesterUtils.leavesMinimumSize(bvh, 9.99f));
    }

    // Uses a deterministic random number generator to create a complex scene
    // Checks to see that the total area of all boundingBoxes in your BVH is not significantly worse than ours
    // This would indicate a highly unbalanced tree / suboptimal splitting logic
    @Tag("score:7")
    @org.junit.jupiter.api.Test
    void BVHQualityTestByArea() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(0, 100, 1000, 1000);
        BVH bvh = new BVH(circles);

        // We allow your solution to be at most 30% worse than our reference implementation
        assertTrue(bvh != null);
        assertEquals(100, PublicTesterUtils.weight(bvh));
        assertTrue(PublicTesterUtils.containsAllCircles(circles, bvh));
        assertTrue(PublicTesterUtils.areCirclesInLeaves(bvh));
        assertTrue(PublicTesterUtils.childrenInsideParents(bvh));
        assertTrue(PublicTesterUtils.leavesMinimumSize(bvh, 9.99f));
        assertTrue(PublicTesterUtils.area(bvh) < 4985143.0 * 1.3);
    }

    // Uses a deterministic random number generator to create a complex scene
    // Checks to see that the total area of all boundingBoxes in your BVH is not significantly worse than ours
    // This would indicate a highly unbalanced tree / suboptimal splitting logic
    @Tag("score:7")
    @org.junit.jupiter.api.Test
    void BVHQualityTestByArea2() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(0, 1000, 1000, 1000);
        BVH bvh = new BVH(circles);

        // We allow your solution to be at most 30% worse than our reference implementation
        assertTrue(bvh != null);
        assertTrue(PublicTesterUtils.containsAllCircles(circles, bvh));
        assertTrue(PublicTesterUtils.areCirclesInLeaves(bvh));
        assertTrue(PublicTesterUtils.childrenInsideParents(bvh));
        assertTrue(PublicTesterUtils.leavesMinimumSize(bvh, 9.99f));
        assertTrue(PublicTesterUtils.area(bvh) < 1.0200572E7 * 1.3);
    }

    // BVH ITERATOR TESTS BELOW

    @Tag("score:6")
    @org.junit.jupiter.api.Test
    void BVHIteratorTest() {
        // This test only checks if your iterator contains ALL circles or not. Order does not matter.
        ArrayList<Circle> expectedCircles = new ArrayList<>();
        expectedCircles.add(new Circle(new Vector2(0,0), 10));
        expectedCircles.add(new Circle(new Vector2(20,0), 10));
        expectedCircles.add(new Circle(new Vector2(40,0), 10));
        expectedCircles.add(new Circle(new Vector2(60,0), 10));
        expectedCircles.add(new Circle(new Vector2(70,0), 10));
        expectedCircles.add(new Circle(new Vector2(80,90), 10));
        expectedCircles.add(new Circle(new Vector2(100,100), 10));
        expectedCircles.add(new Circle(new Vector2(110,110), 10));

        BVH bvh = new BVH(expectedCircles);

        ArrayList<Circle> actualCircles = new ArrayList<>();

        // All of that iteratable/iterator code is so that you can write this oneliner:
        for (Circle c : bvh) {
            actualCircles.add(c);
        }

        // Check for duplicates i.e. all circle.id's should be unique
        HashSet<Integer> actualIds = new HashSet<>();
        for (Circle c : actualCircles)
            actualIds.add(c.id);
        assertEquals(actualIds.size(), actualCircles.size(), "The circles returned by your iterator contains duplicates.");

        // Check that ALL circles were returned. Only ids are used to compare circles.
        HashSet<Integer> expectedIds = new HashSet<>();
        for (Circle c : expectedCircles)
            expectedIds.add(c.id);
        assertEquals(expectedIds, actualIds, "Your iterator did not return all circles contained within the BVH.");
    }
    @org.junit.jupiter.api.Test
    void BVWPerformanceCustom1() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(500, 20000, 20000, 20000);
        BVH bvh = new BVH(circles);
        assertEquals(PublicTesterUtils.weight(bvh), circles.size());
        assertTrue(PublicTesterUtils.areCirclesInLeaves(bvh));
        assertTrue(PublicTesterUtils.childrenInsideParents(bvh));
        assertTrue(PublicTesterUtils.area(bvh) < 4.9E9 * 1.1);
    }

    @org.junit.jupiter.api.Test
    void IteratorCustom1() {
        ArrayList<Circle> circles = PublicTesterUtils.randomInit(500, 20000, 20000, 20000);
        HashSet<Integer> ExpectedIDs = new HashSet<>();
        for (Circle c : circles) {
            ExpectedIDs.add(c.id);
        }
        BVH bvh = new BVH(circles);
        ArrayList<Circle> circlesETree = new ArrayList<>();
        HashSet<Integer> ActualIDs = new HashSet<>();
        for (Circle c : bvh) {
            circlesETree.add(c);
            ActualIDs.add(c.id);
        }
        assertEquals(circlesETree.size(), circles.size());
        assertEquals(ActualIDs, ExpectedIDs);
    }

}
