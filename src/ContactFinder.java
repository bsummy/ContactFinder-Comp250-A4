import java.util.ArrayList;
import java.util.HashSet;

public class ContactFinder {
    // todo for students
    // Returns a HashSet of ContactResult objects representing all the contacts between circles in the scene.
    // The runtime of this method should be O(n^2) where n is the number of circles.
    public static HashSet<ContactResult> getContactsNaive(ArrayList<Circle> circles) {
        HashSet<ContactResult> resultHashSet = new HashSet<ContactResult>();
        ContactResult contact;
        for (int i = 0; i < circles.size(); i++) {
            Circle circleA = circles.get(i);
            for (int j = i + 1; j < circles.size(); j++) {
                Circle circleB = circles.get(j);
                contact = circleB.isContacting(circleA);
                if (circleA.id != circleB.id && contact != null){
                    resultHashSet.add(contact);
                }
            }
        }
        return resultHashSet;
    }
    // todo for students
    // Returns a HashSet of ContactResult objects representing all the contacts between circles in the scene.
    // The runtime of this method should be O(n*log(n)) where n is the number of circles.
    public static HashSet<ContactResult> getContactsBVH(ArrayList<Circle> circles, BVH bvh) {
        HashSet<ContactResult> resultHashSet = new HashSet<ContactResult>();
        for (Circle c : circles){
           resultHashSet.addAll(getContactBVH(c, bvh));
        }
        return resultHashSet;
    }

    // todo for students
    // Takes a single circle c and a BVH bvh.
    // Returns a HashSet of ContactResult objects representing contacts between c
    // and the circles contained in the leaves of the bvh.
    public static HashSet<ContactResult> getContactBVH(Circle c, BVH bvh) {
        HashSet<ContactResult> resultHashSet = new HashSet<ContactResult>();

        boolean cInside = (c.getBoundingBox().intersectBox(bvh.boundingBox));
        if (!cInside){
            return resultHashSet;
        }  else if (cInside && bvh.containedCircle != null && c.id != bvh.containedCircle.id){
            ContactResult contactResult = c.isContacting(bvh.containedCircle);
            if (contactResult != null) {resultHashSet.add(contactResult);}

        } else if (bvh.child1 != null){
            resultHashSet.addAll(getContactBVH(c, bvh.child1));
            resultHashSet.addAll(getContactBVH(c, bvh.child2));
        }
        return resultHashSet;
    }
}
