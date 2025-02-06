package org.example.game.cards;

public interface IsWeapon {
    default public int getMaxWeaponRange(){
      return 1;
    };

    default public int getMinWeaponRange(){
        return 1;
    };

    default public String getWeaponName(){
        return this.getClass().getName();
    };

}
