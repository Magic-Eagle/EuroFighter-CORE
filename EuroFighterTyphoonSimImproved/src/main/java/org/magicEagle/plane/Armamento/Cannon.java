package org.magicEagle.plane.Armamento;

import org.magicEagle.utils.KeyHandler;

/**
 * @Author: CoderAnchel
 * The `canon` class represents a type of armament with specific attributes such as model, caliber,
 * bullet capacity, bullets per second, and explosive damage.
 */
public class Cannon extends Armamento {
   KeyHandler keyHandler;

    public String model = "Mauser BK 27";
    public int caliber = 27;
    public int amo = 150;
    public int bulletPerMinut = 1700;
    // int explosiveDamage;

    public Cannon(KeyHandler keyHandler, Boolean estado) {
        super.estado = estado;
        this.keyHandler = keyHandler;
    }

    public int getAmo(){
        return amo;
    }

    public void shoot(){
        if(amo > 0){
            amo = amo - 1;
        }else{
            System.out.println("OUT OF AMO");
        }
    }
}
