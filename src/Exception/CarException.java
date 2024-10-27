package Exception;

import java.util.Random;

class CarOverheatException extends Exception {
    public CarOverheatException() {

    }

    public CarOverheatException(String msg) {
        super(msg);
    }
}

class LowFuelException extends Exception {
    public LowFuelException() {

    }

    public LowFuelException(String msg) {
        super(msg);
    }
}

class CarBreakdownException extends Exception {
	public CarBreakdownException(String msg) {
        super(msg);
    }
    public CarBreakdownException() {
    }

    
}

class SpeedLimitExceededException extends Exception {
    public SpeedLimitExceededException() {

    }

    public SpeedLimitExceededException(String msg) {
        super(msg);
    }
}

class Car {
    double fuelLevel;
    double engineTemperature;
    double speed;

    public Car(double fuelLevel, double engineTemperature, double speed) {
        this.fuelLevel = fuelLevel;
        this.engineTemperature = engineTemperature;
        this.speed = speed;
    }

    public void drive(double distance, double desiredSpeed) throws LowFuelException, CarOverheatException, SpeedLimitExceededException, CarBreakdownException {
        double mileage = 50.0;
        double fuelTotalDis = mileage * fuelLevel;
        
        // Check for all conditions and throw exceptions simultaneously
        if (fuelTotalDis < distance || engineTemperature > 100 || speed > 120) {
            if (fuelTotalDis < distance)
                throw new LowFuelException("Low fuel level");
            if (engineTemperature > 100)
                throw new CarOverheatException("Car engine getting too hot");
            if (speed > 120)
                throw new SpeedLimitExceededException("Your speed limit is too high");
        }
        
        final double Breakdown_Probability = 0.05;
        Random r = new Random();
        double randomNum = r.nextDouble();
        if (randomNum < Breakdown_Probability) {
            throw new CarBreakdownException("Your car broke down, please slow down.");
        }
    }

}

public class CarException {
    public static void main(String[] args) throws LowFuelException, CarOverheatException, SpeedLimitExceededException, CarBreakdownException
    {
    	try {
        Car c = new Car(1, 200, 150);
            c.drive(100, 110);
            
        } catch (LowFuelException e) {
            System.out.println(e.getMessage());
        } catch (CarOverheatException e) {
            System.out.println(e.getMessage());
        } catch (SpeedLimitExceededException e) {
            System.out.println(e.getMessage());
        } catch (CarBreakdownException e) {
            System.out.println(e.getMessage());
        }
       
    }
}
