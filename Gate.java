package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;

public class Gate {
	private LetThemIn game;
	public int y;
	public int x;
	public int width=80;
	public int height;
	public boolean isClose=true;
	
	public Gate(LetThemIn game,int x,int y){
		this.game=game;
		this.x=x;
		this.y=y;
		this.height = LetThemIn.GATE_HEIGHT;
		width = Gdx.graphics.getWidth()/4;
		
	}
	
	public void render(boolean isClose){
		if(isClose){
			game.batch.draw(game.assets.gate,x,y,width,height);
		}else{
			game.batch.draw(game.assets.open_gate,x,y,width,height);
		}
	}
	
	
	
	public void update(){
		
	}
	
}
