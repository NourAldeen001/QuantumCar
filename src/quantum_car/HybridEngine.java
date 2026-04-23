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
public class HybridEngine implements Engine {
    
    private GasEngine gasEngine = new GasEngine();
    private ElectricEngine electricEngine = new ElectricEngine();
    private int speed = 0;
    
    @Override
    public void increase() {
        speed++;
        updateInternalEngines();
    }

    
    @Override
    public void decrease() {
        if(speed > 0) speed--;
        updateInternalEngines();
    }

    
    @Override
    public void setSpeed(int targetSpeed) {
       speed = targetSpeed;
       updateInternalEngines();
    }

    @Override
    public int getSpeed() {
        return speed;
    }
    
    @Override
    public String getType() {
        return "Hybrid";
    }

    private void updateInternalEngines() {
        if(speed < 50) {
            electricEngine.setSpeed(speed);
            gasEngine.setSpeed(0);
        }
        else {
            gasEngine.setSpeed(speed);
            electricEngine.setSpeed(0);
        }
    }
    
    public String getActiveEngine() {
        return speed < 50 ? "Electric" : "Gas";
    }
    
}
