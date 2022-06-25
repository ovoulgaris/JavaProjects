import java.util.Scanner;

public class Main {
    private static int safetyFactor;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int altitude = setAltitude();


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

    }

    public static int setAltitude () {
        System.out.println("Please enter the drop altitude in thousands of feet");
        while (!scanner.hasNextInt()) {
            System.out.println("Error! Wrong input.");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    public static int setParatroopers () {
        System.out.println("How many paratroopers will operate?");
        while (!scanner.hasNextInt()) {
            System.out.println("Error! Wrong input.");
            scanner.nextLine();
        }
        return scanner.nextInt();
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