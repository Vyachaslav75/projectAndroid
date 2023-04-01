package com.mygdx.game.Units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected int arrows;
    protected  int arrowsMax;
    public Shooter(int health, int attack, int minDamage, int maxDamage,
                   int armor, int speed, String name, int x, int y, int arrows) {
        super(health, attack, minDamage, maxDamage, armor, speed, name, x, y);
        this.arrows = arrows;
        this.arrowsMax = arrows;
    }
    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> friends) {
        int indx = this.findNeaby(enemy);
        if (indx > -1) {
            if (this.arrows > 0 && this.health > 0) {
                BaseHero hero;
                //int indx = this.findNeaby(enemy);
                hero = enemy.get(indx);
                if (hero.health > 0) {
                    this.attackEnemy(hero);
                    this.arrows--;
                }
            }
            for (BaseHero hero : friends) {
                if (hero.getType().equals("Крестьянин") && this.arrows < this.arrowsMax) {
                    this.arrows++;
                    break;
                }
            }
        }
    }
}
