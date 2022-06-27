import java.util.ArrayList;

public class Calculator {
    private final int altitude;
    private final int safetyFactor;

    private double canopySpeedConstant = 20.8;
    private int canopyDriftConstant = 48;
    private int paratroopers;

    public Calculator(int altitude, int safetyFactor, int paratroopers) {
        this.altitude = altitude;
        this.safetyFactor = safetyFactor;
        this.paratroopers = paratroopers;
        calculateReleasePoint();
    }

    private int calculateDispersion () {
        return paratroopers / 2 * 50 / 100;
    }

    public void calculateReleasePoint () {
        double glidingDistance;
        WindCalculator windCalculator = new WindCalculator(altitude);
        glidingDistance = ((altitude - safetyFactor)*(windCalculator.getAverageWindSpeed() + canopySpeedConstant)
                / canopyDriftConstant);
        glidingDistance *= 1.85;
        double forwardThrow = 0.3;
        glidingDistance += forwardThrow;
        glidingDistance += calculateDispersion();

        glidingDistance = Math.round(glidingDistance * 100) / 100;

        System.out.printf(glidingDistance + "km at " + windCalculator.getAverageWindDirection() + " degrees");
    }

}
