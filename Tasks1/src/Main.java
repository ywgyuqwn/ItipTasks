public class Main {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println(containers(3, 4,2));
        System.out.println(containers(5, 0,2));
        System.out.println(containers(4, 1,4));
        System.out.println(triangleType(5, 5,5));
        System.out.println(triangleType(5, 4,5));
        System.out.println(triangleType(3, 4,5));
        System.out.println(triangleType(5, 1,1));
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println(howManyItems(22, 1.4,2));
        System.out.println(howManyItems(45, 1.8,1.9));
        System.out.println(howManyItems(100, 2,2));
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    public static double convert(int gallons) {
        return gallons * 3.785;
    }

    public static int fitCalc(int minutes, int intensity) {
        return minutes * intensity * 1;
    }

    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x <= 0 || y <= 0 || z <= 0 || x + y <= z || x + z <= y || y + z <= x)
            return "not a triangle";
        if (x == y && y == z)
            return "equilateral";
        if (x == y || y == z || x == z)
            return "isosceles";
        return "different-sided";
    }

    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }


    public static int howManyItems(int n, double w, double h) {
        return (int) ((n * 2) / (w * h));
    }


    public static int factorial(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }


    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }


    public static int ticketSaler(int tickets, int price) {
        return tickets * price;
    }


    public static int tables(int students, int desks) {
        return Math.max(0, (students + 1) / 2 - desks);
    }
}