import java.util.Scanner;

public class Main {
    private static int safetyFactor;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter the drop altitude in thousands of feet.");
        int altitude = readInt();
        System.out.println("How many paratroopers will operate?");
        int paratroopers = readInt();
        int canopyAssemblyHeight = 0;
        int landingPatternEstablishmentHeight = 0;
        boolean gotInput = false;
        while (!gotInput) {
            System.out.println("Please enter the canopy Assembly Height required in thousands of feet.");
            canopyAssemblyHeight = readInt();
            System.out.println("Please enter the landing pattern establishment height required in thousands of feet.");
            landingPatternEstablishmentHeight = readInt();
            gotInput = calculateSF(canopyAssemblyHeight, landingPatternEstablishmentHeight);
        }

        Calculator jumpCalculator = new Calculator(altitude, safetyFactor, paratroopers);

    }

    public static int readInt() {
        int input = -1;
        while (input <= 0){
            while (!scanner.hasNextInt()) {
                System.out.println("Error! Wrong input.");
                scanner.nextLine();
            }
            input = scanner.nextInt();
            if (input <= 0) {
                System.out.println("You will need to input a number greater than 0");
            }
        }
        return input;
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