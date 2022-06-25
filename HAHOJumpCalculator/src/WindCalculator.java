import java.util.ArrayList;
import java.util.Scanner;

public class WindCalculator {

    private ArrayList<Integer> windSpeeds = new ArrayList<>();
    private ArrayList<Integer> windDirections = new ArrayList<>();
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
        Scanner scanner = new Scanner(System.in);
        while (altitude > 0) {
            System.out.println("Enter wind velocity at " + altitude + "000 thousand feet.");
            windSpeeds.add(scanner.nextInt());
            System.out.println("Enter wind direction at " + altitude + "000 thousand feet.");
            windDirections.add(scanner.nextInt());
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
}
