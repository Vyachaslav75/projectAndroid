package com.mygdx.game.Units;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero {
    protected int moves;
    public Infantry(int health, int attack, int minDamage, int maxDamage, int armor,
                    int speed, String name, int x, int y, int moves) {
        super(health, attack, minDamage, maxDamage, armor, speed, name, x, y);
        this.moves = moves;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> friends) {
        int indx = this.findNeaby(enemy);
        if (indx > -1) {
            BaseHero hero = enemy.get(indx);
            if (this.health > 0 && canAttack(hero) && hero.health > 0) {
                this.attackEnemy(hero);
            } else if (this.health > 0) {
                this.move(hero.position, friends);
            }
        }
    }
    private boolean canAttack(BaseHero enemy){
        if (this.position.distance(enemy.position.x, enemy.position.y) < 2){
            return true;
        }else {
            return false;
        }
    }
}
