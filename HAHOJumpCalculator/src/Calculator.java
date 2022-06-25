import java.util.ArrayList;

public class Calculator {
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

    private int calculateDispersion () {
        return paratroopers / 2 * 50 / 100;
    }

//    public void calculateReleasePoint () {
//        double glidingDistance;
//        glidingDistance = ((altitude - safetyFactor)*(windAverages.get(0) + canopySpeedConstant)
//                / canopyDriftConstant);
//        glidingDistance *= 1.85;
////        glidingDistance += forwardThrow;
////        glidingDistance += calculateDispersion();
//
//        glidingDistance = Math.round(glidingDistance * 100) / 100;
//
//        System.out.printf(glidingDistance + "km at " + windAverages.get(1) + " degrees");
//    }

}
