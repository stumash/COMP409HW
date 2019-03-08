public class Edge {
    public final Point p1, p2;
    public Edge(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean intersects(Edge other) {
        // get line equation for this edge
        double x1_1 = this.p1.getX();
        double x2_1 = this.p2.getX();
        double y1_1 = this.p1.getY();
        double y2_1 = this.p2.getY();

        double a1 = (y2_1 - y1_1) / (x2_1 - x1_1);
        double b1 = y1_1 - a1 * x1_1;

        // get line equation for other edge
        double x1_2 = other.p1.getX();
        double x2_2 = other.p2.getX();
        double y1_2 = other.p1.getY();
        double y2_2 = other.p2.getY();

        double a2 = (y2_2 - y1_2) / (x2_2 - x1_2);
        double b2 = y1_2 - a1 * x1_2;

        // get intersection point
        double x_intersect = (b2 - b1) / (a1 - a2);
        double y_intersect = a1 * x_intersect + b1;

        // return true if intersection is in bounds of both edges/line segments
        boolean x_in_bounds = 
            x_intersect >= x1_1 && x_intersect <= x2_1 &&
            x_intersect >= x1_2 && x_intersect <= x2_2;
        boolean y_in_bounds =
            y_intersect >= y1_1 && y_intersect <= y2_1 &&
            y_intersect >= y1_2 && y_intersect <= y2_2;

        return x_in_bounds && y_in_bounds;
    }
}