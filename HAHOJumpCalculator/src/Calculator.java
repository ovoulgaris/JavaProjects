import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> windVelocities = new ArrayList<>();
    private ArrayList<Integer> windDirections = new ArrayList<>();
    private ArrayList<Integer> windAverages = new ArrayList<>();
    private int altitude;
    private int safetyFactor;

    private double forwardThrow = 0.3;
    private double canopySpeedConstant = 20.8;
    private int canopyDriftConstant = 48;
    private final int paratroopers;

    public Calculator(int altitude, int safetyFactor, int paratroopers) {
        this.altitude = altitude;
        this.safetyFactor = safetyFactor;
        this.paratroopers = paratroopers;
    }

    public void getWindData() {
//        Scanner scanner = new Scanner(System.in);
//        int calcAltitude = altitude;
//        while (calcAltitude > 0) {
//            System.out.println("Enter wind velocity at " + calcAltitude + "000 thousand feet.");
//            windVelocities.add(scanner.nextInt());
//            System.out.println("Enter wind direction at " + calcAltitude + "000 thousand feet.");
//            windDirections.add(scanner.nextInt());
//            if (calcAltitude > 10) {
//                calcAltitude -= 2;
//            } else calcAltitude -= 1;
//        }
        windVelocities.add(25);
        windVelocities.add(22);
        windVelocities.add(21);
        windVelocities.add(21);
        windVelocities.add(20);
        windVelocities.add(18);
        windVelocities.add(18);
        windVelocities.add(17);
        windVelocities.add(16);
        windVelocities.add(12);
        windVelocities.add(12);
        windVelocities.add(8);

        windDirections.add(90);
        windDirections.add(80);
        windDirections.add(90);
        windDirections.add(90);
        windDirections.add(85);
        windDirections.add(80);
        windDirections.add(80);
        windDirections.add(85);
        windDirections.add(80);
        windDirections.add(75);
        windDirections.add(80);
        windDirections.add(80);

        calculateWindAverages();
    }

    public void calculateWindAverages() {
        int sum = 0;
        for (Integer i : windVelocities) {
            sum += i;
        }
        windAverages.add(sum / windVelocities.size());
        sum = 0;
        for (Integer i : windDirections) {
            sum += i;
        }
        windAverages.add(sum / windDirections.size());
        System.out.println(windAverages.get(0));
        System.out.println(windAverages.get(1));
    }

    private int calculateDispersion () {
        return paratroopers / 2 * 50 / 100;
    }

    public void calculateReleasePoint () {
        double glidingDistance;
        glidingDistance = ((altitude - safetyFactor)*(windAverages.get(0) + canopySpeedConstant)
                / canopyDriftConstant);
        glidingDistance *= 1.85;
//        glidingDistance += forwardThrow;
//        glidingDistance += calculateDispersion();

        glidingDistance = Math.round(glidingDistance * 100) / 100;

        System.out.printf(glidingDistance + "km at " + windAverages.get(1) + " degrees");
    }

}
