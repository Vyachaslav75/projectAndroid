package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Units.BaseHero;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan, robber;
	Music music;

	public static final int GANG_SIZE = 10;
	public static ArrayList<BaseHero> teamWhite;
	public static ArrayList<BaseHero> teamBlack;
	public static int step = 0;
	private static float dx, dy;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fons/"+String.valueOf(new Random().nextInt(5))+".png");
		music = Gdx.audio.newMusic(
				Gdx.files.internal(
						"music/paul-romero-rob-king-combat-theme-0"+String.valueOf(new Random().nextInt(4)+1)+".mp3"));
		music.setVolume(.125f);
		music.setLooping(true);
		music.play();
		Init.createTeams();

		int my = 0;
		crossBowMan = new Texture("units/CrossBowMan.png");
		my = crossBowMan.getHeight();
		mage =  new Texture("units/Mage.png");
		if (my < mage.getHeight()) my = mage.getHeight();
		peasant = new Texture("units/Peasant.png");
		if (my < peasant.getHeight()) my = peasant.getHeight();
		monk = new Texture("units/Monk.png");
		if (my < monk.getHeight()) my = monk.getHeight();
		rouge = new Texture("units/Rouge.png");
		if (my < rouge.getHeight()) my = rouge.getHeight();
		sniper = new Texture("units/Sniper.png");
		if (my < sniper.getHeight()) my = sniper.getHeight();
		spearMan = new Texture("units/SpearMan.png");
		if (my < spearMan.getHeight()) my = spearMan.getHeight();
		dx = dy = Gdx.graphics.getHeight() / 10;

	}

	@Override
	public void render () {
		if (step == 0) Gdx.graphics.setTitle("Первый ход."); else Gdx.graphics.setTitle("Ход №"+step);

		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

//		teamBlack.forEach(n -> {
//			switch (n.getType()){
//				case "Bandit":
//					if (n.health>0)batch.draw(rouge, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
//				case "Peasant":
//					if (n.health>0)batch.draw(peasant, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
//				case "Sniper":
//					if (n.health>0)batch.draw(sniper, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
//				case "Witch":
//					if (n.health>0)batch.draw(mage, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
//			}
//		});
		for (BaseHero hero :
				teamBlack) {
			switch (hero.getType()){
				case "Bandit":
					if (hero.health>0)batch.draw(robber, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
				case "Peasant":
					if (hero.health>0)batch.draw(peasant, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
				case "Sniper":
					if (hero.health>0)batch.draw(sniper, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
				case "Witch":
					if (hero.health>0)batch.draw(mage, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
			}
		}

//		teamWhite.forEach(n -> {
//			switch (n.getType()) {
//				case "Monk":
//					if (n.health>0)batch.draw(monk, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
//				case "Peasant":
//					if (n.health>0)batch.draw(peasant, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
//				case "Spearman":
//					if (n.health>0)batch.draw(spearMan, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
//				case "Crossbowman":
//					if (n.health>0))batch.draw(crossBowMan, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
//			}
//		});
		for (BaseHero hero :
				teamWhite) {
			switch (hero.getType()){
				case "Bandit":
					if (hero.health>0)batch.draw(monk, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
				case "Peasant":
					if (hero.health>0)batch.draw(peasant, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
				case "Sniper":
					if (hero.health>0)batch.draw(spearMan, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
				case "Witch":
					if (hero.health>0)batch.draw(crossBowMan, hero.getPosition().getX()*dx, (hero.getPosition().getY()-1)*dy); break;
			}
		}

		batch.end();

//		while (Init.teamIsAlive(teamWhite) && Init.teamIsAlive(teamBlack))
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			step++;
			Init.makeStep();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}