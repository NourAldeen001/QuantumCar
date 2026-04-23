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
public class Car {
    
    private Engine engine;
    private int speed;
    private boolean started = false;
    
    public Car(Engine engine) {
        this.engine = engine;
    }
    
    
    public void start() {
        if(!started) {
            started = true;
            speed = 0;
            engine.setSpeed(speed);
            System.out.println("Car started with " + engine.getType() + " engine at 0 km/h");
        }
        else {
            System.out.println("Car already started");
        }
    } 
    
    public void stop() {
        if(!started) {
            System.out.println("Car already stopped");
        }
        else if(speed != 0) {
            System.out.println("Cannot stop: Speed must be 0. Current speed: " + speed + " km/h");
        }
        else {
            started = false;
            engine.setSpeed(0);
            System.out.println("Car stopped");
        }
    }
    
    public void accelerate() {
        if(!started) {
            System.out.println("Cannot accelerate: Car is not started");
            return;
        }
        int newSpeed = Math.min(speed + 20, 200);
        if(newSpeed == speed) {
            System.out.println("Maximum speed reached: 200 km/h");
            return;
        }
        speed = newSpeed;
        engine.setSpeed(speed);
        System.out.println("Accelerated to " + speed + " km/h" + getEngineInfo());
    }
    
    public void brake() {
        if(!started) {
            System.out.println("Cannot brake: Car is Stopped");
            return;
        }
        speed = Math.max(speed - 20, 0);
        engine.setSpeed(speed);
        System.out.println("Braked to " + speed + " km/h " + getEngineInfo());
    }
    
    
    public void setEngine(Engine engine) {
        this.engine = engine;
        engine.setSpeed(speed);
        System.out.println("Engine replaced with " + engine.getType());
    }
    
    private String getEngineInfo() {
        if(engine instanceof HybridEngine) {
            return "[Active: " + ((HybridEngine) engine).getActiveEngine() + "]";
        }
        return "";
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isStarted() {
        return started;
    }
    
}
