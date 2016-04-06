package com.mygdx.letthemin;



public class Background {
	
	final LetThemIn game;
	private int bg_width =64;
	private int bg_height = 64;
	private int line_width=1;
	private int line_height=32;
	
	
	public Background(LetThemIn game){
		this.game=game;
		
		
	}
	
	public void render(){
		for(int y=0; y <LetThemIn.GAME_HEIGHT/bg_height +1; y++){
			for(int x=0; x< LetThemIn.GAME_WIDTH/bg_width+1; x++){
				game.batch.draw(game.assets.background,x*bg_width,y*bg_height);
			}
		}
		
		for(int x=1; x<=3;x++){
			for(int y=0; y <LetThemIn.GAME_HEIGHT/line_height +1; y++){
				game.batch.draw(game.assets.line,((x*LetThemIn.GAME_WIDTH/4) -1), y*line_height);
			}
		}
		
		
	}
	
	public void menuRender(){
		for(int y=0; y <LetThemIn.GAME_HEIGHT/bg_height +1; y++){
			for(int x=0; x< LetThemIn.GAME_WIDTH/bg_width+1; x++){
				game.batch.draw(game.assets.background,x*bg_width,y*bg_height);
			}
		}
	}
}
