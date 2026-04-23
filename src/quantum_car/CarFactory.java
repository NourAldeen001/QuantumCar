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
public class CarFactory {

    
    public enum EngineType { GAS, ELECTRIC, HYBRID }
    
    public Car createCar(EngineType engineType) {
        Engine engine = createEngine(engineType);
        System.out.println("Created car with " + engineType.name() + " engine");
        return new Car(engine);
    }
    
    private Engine createEngine(EngineType engineType) {
        switch(engineType) {
            case GAS: return new GasEngine();
            case ELECTRIC: return new ElectricEngine();
            case HYBRID: return new HybridEngine();
            default: throw new IllegalArgumentException("Unknown engine type");
        }
    }
    
    public void replaceEngine(Car car, EngineType engineType) {
        car.setEngine(createEngine(engineType));
    }
    
}
