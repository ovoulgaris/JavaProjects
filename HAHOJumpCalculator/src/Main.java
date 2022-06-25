import java.util.Scanner;

public class Main {
    private static int safetyFactor;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the drop altitude in thousands of feet");
        int altitude = scanner.nextInt();

        boolean gotInput = false;
        while (!gotInput) {
            System.out.println("Please enter the canopy Assembly Height required in thousands of feet");
            int canopyAssemblyHeight = scanner.nextInt();
            System.out.println("Please enter the landing pattern establishment height required in thousands of feet");
            int landingPatternEstablishmentHeight = scanner.nextInt();
            gotInput = calculateSF(canopyAssemblyHeight, landingPatternEstablishmentHeight);
        }

        System.out.println("How many paratroopers will operate?");
        int paratroopers = scanner.nextInt();

        Calculator jumpCalculator = new Calculator(altitude, safetyFactor, paratroopers);
        jumpCalculator.getWindData();
        jumpCalculator.calculateReleasePoint();

    }
    public static boolean calculateSF (int a, int b) {
        safetyFactor = (a + b);
        if (safetyFactor < 2) {
            System.out.println("Less than the minimum height for canopy assembly and landing pattern establishment");
            return false;
        }
        else return true;
    }

}