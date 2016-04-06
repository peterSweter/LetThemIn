package com.mygdx.letthemin;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ScoreManager {
	
	private GameScreen game;

	
	public ScoreManager(GameScreen game){
		this.game= game;
		
	}
	
	public void render(){
		
		game.game.white_font_48.draw(game.game.batch, game.score+" ", 10, LetThemIn.GAME_HEIGHT-5);
	}

}
