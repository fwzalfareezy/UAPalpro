package Art;

public class ArtCalculator {

    public static double calculateSquareArea(double sideLength) {
        return sideLength * sideLength;
    }

    public static double calculateSquarePerimeter(double sideLength) {
        return 4 * sideLength;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateCirclePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public static boolean isAreaGreaterThanPerimeter(double area, double perimeter) {
        return area > perimeter;
    }
}
