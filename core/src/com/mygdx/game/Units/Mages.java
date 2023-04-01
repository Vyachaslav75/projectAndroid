package com.mygdx.game.Units;

import java.util.ArrayList;

public abstract class Mages extends BaseHero {
    protected int mana;
    protected int manaMax;

    public Mages(int health, int attack, int minDamage, int maxDamage, int armor,
                 int speed, String name, int x, int y, int mana) {
        super(health, attack, minDamage, maxDamage, armor, speed, name, x, y);
        this.mana = mana;
        this.manaMax = mana;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> friends) {
        int indx = this.findNeaby(friends);
        if (indx > -1) {
            if (this.mana > 0 && this.health > 0) {
                BaseHero hero;
                //int indx = this.findNeaby(enemy);
                hero = friends.get(indx);
                if (hero.health > 0) {
                    this.attackEnemy(hero);
                    this.mana--;
                }
            }else if (this.health > 0 && this.mana < this.manaMax){
                this.mana++;
            }
        }
    }
}
