import java.awt.*;
import java.util.ArrayList;

import java.util.Iterator;


public class BVH implements Iterable<Circle>{
    Box boundingBox;
    BVH child1;
    BVH child2;
    Circle containedCircle;

    // todo for students
    public BVH(ArrayList<Circle> circles) {
        ArrayList<Circle>[] splitArray;
        ArrayList<Circle> leftChildren;
        ArrayList<Circle> rightChildren;

        this.boundingBox = buildTightBoundingBox(circles);
        if (circles.size() > 1){
            splitArray = split(circles, this.boundingBox);
            leftChildren = splitArray[0];
            rightChildren = splitArray[1];
            this.child1 = new BVH(leftChildren);
            this.child2 = new BVH(rightChildren);
        } else if (circles.size() == 1){
            this.containedCircle = circles.get(0);
        }
    }

    public void draw(Graphics2D g2) {
        this.boundingBox.draw(g2);
        if (this.child1 != null) {
            this.child1.draw(g2);
        }
        if (this.child2 != null) {
            this.child2.draw(g2);
        }
    }

    // todo for students
    public static ArrayList<Circle>[] split(ArrayList<Circle> circles, Box boundingBox) {
        boolean x_axis = true;
        ArrayList<Circle>[] resultChildrenArray = new ArrayList[2];
        ArrayList<Circle> leftChildren =new ArrayList<>();
        ArrayList<Circle> rightChildren = new ArrayList<>();


        if (boundingBox.getHeight() >= boundingBox.getWidth()){
            x_axis = false;
        }

        if (x_axis){
            double mid_x = boundingBox.getMidX();
            for (int i = 0; i < circles.size(); i++) {
                Circle circle = circles.get(i);
                if (mid_x >= (circle).position.x){
                    //on left of quadrant 1 less than x_mid
                    leftChildren.add(circle);

                } else{
                    //on right of quadrant 1 greater than x_mid
                    rightChildren.add(circle);
                }
            }
        } else{
            double mid_y = boundingBox.getMidY();
            for (int i = 0; i < circles.size(); i++) {
                Circle circle = circles.get(i);
                if (mid_y >= (circle).position.y){
                    //technically bottom
                    leftChildren.add(circle);
                } else{
                    //technically top
                    rightChildren.add(circle);
                }
            }
        }

        resultChildrenArray[0] = leftChildren;
        resultChildrenArray[1] = rightChildren;

        return resultChildrenArray;
    }

    // returns the smallest possible box which fully encloses every circle in circles
    public static Box buildTightBoundingBox(ArrayList<Circle> circles) {
        Vector2 bottomLeft = new Vector2(Float.POSITIVE_INFINITY);
        Vector2 topRight = new Vector2(Float.NEGATIVE_INFINITY);

        for (Circle c : circles) {
            bottomLeft = Vector2.min(bottomLeft, c.getBoundingBox().bottomLeft);
            topRight = Vector2.max(topRight, c.getBoundingBox().topRight);
        }

        return new Box(bottomLeft, topRight);
    }

    // METHODS BELOW RELATED TO ITERATOR

    // todo for students
    @Override
    public Iterator<Circle> iterator() {
        return new BVHIterator(this);
    }

    public class BVHIterator implements Iterator<Circle> {
        private int currentIndex = 0;
        private int currentSize;
        ArrayList<Circle> circleArrayList = new ArrayList<>();


        // todo for students
        public BVHIterator(BVH bvh) {
            //constructor??
            if (bvh.child1 != null) {
                BVHIterator child1Iterator =  new BVHIterator(bvh.child1);
                this.circleArrayList.addAll(child1Iterator.circleArrayList);
            } else{
                this.circleArrayList.add(bvh.containedCircle);
            }

            if (bvh.child2 != null) {
                BVHIterator child2Iterator =  new BVHIterator(bvh.child2);
                this.circleArrayList.addAll(child2Iterator.circleArrayList);
            }

            this.currentSize = this.circleArrayList.size();
        }

        // todo for students
        @Override
        public boolean hasNext() {
            return currentIndex < currentSize && circleArrayList.get(currentIndex) != null;
        }

        // todo for students
        @Override
        public Circle next() {
            return this.circleArrayList.get(currentIndex++);
        }

    }
}
