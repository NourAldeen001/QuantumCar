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
public class ElectricEngine implements Engine {
    
    private int speed = 0;
    
    @Override
    public void increase() {
        speed++;
    }

    
    @Override
    public void decrease() {
        if(speed > 0) speed--;
    }

    
    @Override
    public void setSpeed(int targetSpeed) {
       while(speed < targetSpeed) increase();
       while(speed > targetSpeed) decrease();
    }

    @Override
    public int getSpeed() {
        return speed;
    }
    
    @Override
    public String getType() {
        return "Electric";
    }
    
}
