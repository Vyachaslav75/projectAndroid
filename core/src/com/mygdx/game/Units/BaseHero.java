package com.mygdx.game.Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements BaseInterface{
    protected static int number;
    protected static Random r;
    public int health;
    protected int attack;
    protected int minDamage;
    protected int maxDamage;
    protected int armor;
    protected int speed;
    //protected int experience;
    protected final String NAME;
    protected int maxHP;
    //protected int x;
    //protected int y;
    protected Positions position;
    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(int health, int attack, int minDamage, int maxDamage,
                    int armor, int speed, String name, int x, int y) {
        this.health = health;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.armor = armor;
        this.speed = speed;
        NAME = name;
        this.maxHP = health;
        //this.x = x;
        //this.y = y;
        position = new Positions(x, y);

    }
    public BaseHero(String name, int x, int y) {
        this(1,1,1,1,1,3,
                name, x ,y);
        //this.name = name;
    }
    @Override
    public String getInfo(){
        return String.format("Name: %s Hp: %d Type: %s",
                NAME, this.health, this.getClass().getSimpleName());
    }

    @Override
    public void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {
        //System.out.println(this.getType());

    }
    public String getType(){return "";}

    public int getSpeed() {
        return this.speed;
    }

//    public void healed(int hp){
//        this.health = hp + this.health > this.maxHP ? this.maxHP : hp + this.health;
//    }
    public void takeDamage(int damage){
        //damage = BaseHero.r.nextInt(this.minDamage, this.maxDamage);
//        if (damage < 0){
//            healed(damage);
//        }else if (this.health - damage > 0){
//            this.health -= damage;
//        }
        if (this.health - damage < 0){
            this.health = 0;
        }else {
            this.health -= damage;
        }

    }
    public void attackEnemy(BaseHero target){
        //int damage = BaseHero.r.nextInt(this.minDamage, this.maxDamage);
        int damage = (this.minDamage + this.maxDamage)/2;
        target.takeDamage(damage);
    }
    public Positions getPosition(){
        return position;
    }
    public String getName(){return "";}

    public int findNeaby(ArrayList<BaseHero> target){
        double dist = 20;
        BaseHero hero;
        int indx = -1;
        for (int i = 0; i < target.size(); i++) {
            hero = target.get(i);
            if (hero.health > 0 && dist > this.position.distance(hero.position.x, hero.position.y)
                    && this.position.distance(hero.position.x, hero.position.y) > 0){
                dist = this.position.distance(hero.position.x, hero.position.y);
                indx = i;
            }
        }
        return indx;
    }
    public void move(Positions targetPos, ArrayList<BaseHero> heroes){
        boolean[] temp = checkPos(heroes);
        float dx = Math.abs(this.position.x - targetPos.x);
        float dy = Math.abs(this.position.y - targetPos.y);
        if (dx > dy){
            if (this.position.x < targetPos.x & !temp[0]) this.position.x++;
            else if (!temp[1]) this.position.x--;
        }else {
            if (this.position.y < targetPos.y & !temp[2]) this.position.y++;
            else if (!temp[3]) this.position.y--;
        }
    }
    public boolean[] checkPos(ArrayList<BaseHero> heroes){
        boolean[] temp = new boolean[4];
        for (BaseHero hero: heroes) {
            if ((hero.position.x == this.position.x+1) & (hero.position.y == this.position.y)) temp[0] = true;
            if ((hero.position.x == this.position.x-1) & (hero.position.y == this.position.y)) temp[1] = true;
            if ((hero.position.x == this.position.x) & (hero.position.y == this.position.y+1)) temp[2] = true;
            if ((hero.position.x == this.position.x) & (hero.position.y == this.position.y-1)) temp[3] = true;
        }
        return temp;
    }
}
