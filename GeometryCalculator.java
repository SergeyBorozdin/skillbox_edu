public class GeometryCalculator {

    public static void main(String[] args) {

        int radius = 3, sideA = 5, sideB = 7, sideC = 5;

        System.out.println(circleArea(radius));
        System.out.println(triangleArea(sideA, sideB, sideC));
        System.out.println(ballArea(radius));
        System.out.println(triangleCheck(sideA, sideB, sideC));
    }

    public static double circleArea (int r) {
        return Math.PI * (Math.pow(r, 2));
    }

    public static double triangleArea (int a, int b, int c) {
        int p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double ballArea (int r) {
        return (4 * Math.PI * Math.pow(r, 3)) / 3 ;
    }

    public static boolean triangleCheck (int a, int b, int c) {
        return a + b > c && b + c > a && c + a > b;
    }
}
