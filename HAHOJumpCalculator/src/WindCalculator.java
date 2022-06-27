import java.util.ArrayList;
import java.util.Scanner;

public class WindCalculator {

    private final ArrayList<Integer> windSpeeds = new ArrayList<>();
    private final ArrayList<Integer> windDirections = new ArrayList<>();
    private double averageWindSpeed;
    private double averageWindDirection;

    public WindCalculator(int altitude) {
        setWindData(altitude);
        calculateAverageWindDirection();
        calculateAverageWindSpeed();
    }

    public double getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public double getAverageWindDirection() {
        return averageWindDirection;
    }

    private void setWindData (int altitude) {
        while (altitude > 0) {
            System.out.println("Enter wind velocity at " + altitude + "000 thousand feet.");
            windSpeeds.add(readInt());
            System.out.println("Enter wind direction at " + altitude + "000 thousand feet.");
            windDirections.add(readInt());
            if (altitude > 10) {
                altitude -= 2;
            } else altitude -= 1;
        }
    }

    private void calculateAverageWindSpeed () {
        averageWindSpeed = calculateAverage(windSpeeds);
    }

    private void calculateAverageWindDirection () {
        averageWindDirection = calculateAverage(windDirections);
    }

    private double calculateAverage (ArrayList<Integer> arrayList) {
        int sum  = 0;
        for (Integer i : arrayList) {
            sum += arrayList.get(i);
        }
        return sum;
    }

    private int readInt() {
        Scanner scanner = new Scanner(System.in);
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
}
