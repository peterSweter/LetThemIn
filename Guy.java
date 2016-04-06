package com.mygdx.letthemin;

import com.badlogic.gdx.math.MathUtils;

public class Guy {
	public int type;
	public int width;
	public int height;
	public int x,y;
	public boolean active;
	private LetThemIn game;
	
	public Guy(LetThemIn game, int type){
		this.game = game;
		this.type = type;
		active= false;
		this.y=LetThemIn.GAME_HEIGHT + height;
		width=height=LetThemIn.GATE_HEIGHT;
		//width=height=32;

		
		
	}
	
	public void render(float delta){
		if(type==1){
			game.batch.draw(game.assets.good_guy,x,y,width,height);
			
			
			
		}else{
			game.batch.draw(game.assets.bad_guy,x,y,(int)width,(int)height);
		}
		
		
	}
	
	public void toggle(){
		if(this.active){
			this.active = false;
		}else{
			this.active = true;
		}
	}
	
	public void set(int row){
		this.x= row * LetThemIn.GAME_WIDTH/4  + (LetThemIn.GAME_WIDTH/4 - width)/2 ;
		this.y=LetThemIn.GAME_HEIGHT + height;
		
		if(MathUtils.random(0,100)>=50){
			this.type=1;
		}else{
			this.type=2;
		}
		
	}
	
}
