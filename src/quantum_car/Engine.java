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
public interface Engine {
    
    void increase();
    void decrease();
    void setSpeed(int speed);
    int getSpeed();
    String getType();
    
}
