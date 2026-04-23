/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantum_car;

/**
 *
 * @author xps
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CarFactory factory = new CarFactory();
        
        // Test Gas Car
        System.out.println("===== Gas Car ======");
        Car gasCar = factory.createCar(CarFactory.EngineType.GAS);
        testBasicOperations(gasCar);
        
        // Test Electric Car
        System.out.println("===== Electric car ======");
        Car electricCar = factory.createCar(CarFactory.EngineType.ELECTRIC);
        testBasicOperations(electricCar);      
        
        // Test Hybrid Car
        System.out.println("===== Hybrid Car ======");
        Car hybridCar = factory.createCar(CarFactory.EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate(); // 20 km/h - electric
        hybridCar.accelerate(); // 40 km/h - electric
        hybridCar.accelerate(); // 60 km/h (At 50, Switch from electric to gas)
        hybridCar.accelerate(); // 80 km/h - Gas
        hybridCar.brake(); // 60 km/h - Gas
        hybridCar.brake(); // 40 km/h - (At 49, Switch from electric to gas)
        hybridCar.brake(); // 20 km/h - electric
        hybridCar.brake(); // 0 km/h
        hybridCar.stop();
        
        // Test Car Replacement
        System.out.println("===== Engine replacement ======");
        Car replaceableCar = factory.createCar(CarFactory.EngineType.GAS);
        replaceableCar.start();
        replaceableCar.accelerate();
        replaceableCar.accelerate();
        System.out.println("Speed before replacement: " + replaceableCar.getSpeed());
        factory.replaceEngine(replaceableCar, CarFactory.EngineType.HYBRID);
        replaceableCar.accelerate();
        
        // Test Max Speed Limit
        System.out.println("===== MAX SPEED TEST ======");
        Car speedCar = factory.createCar(CarFactory.EngineType.GAS);
        speedCar.start();
        for(int i = 0; i < 12; i++) speedCar.accelerate();
    }

    private static void testBasicOperations(Car car) {
        car.start();
        car.accelerate();
        car.accelerate();
        car.brake();
        System.out.println("Still moving");
        car.stop();
        car.brake();
        car.stop();
    }
    
}
