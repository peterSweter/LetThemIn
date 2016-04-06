package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

public class PlayAgain {
	private GameScreen game;
	private Sprite play_again_button;
	private Sprite game_over;
	public Sprite voiceButton;
	public Sprite your_score, high_score;
	
	public Sprite return_to_menu;
	
	
	
	private boolean is_h_score;
	public float ratio;
	
	public int play_again_width =260;
	public int play_again_height =60;
	
	public int score_width = 180;
	public int score_height = 40;

	public int container_width = LetThemIn.GAME_WIDTH;
	public int container_height=(int) (260 * LetThemIn.ratio);
	
	public int voice_width =40;
	public int voice_height =40;
	
	
	
	
	
	public PlayAgain(GameScreen game){
		this.game= game;
		this.ratio = LetThemIn.ratio;
		
		your_score = new  Sprite(game.game.assets.your_score);
		high_score = new  Sprite(game.game.assets.high_score);
		
		your_score.setSize(score_width * ratio, score_height * ratio);
		high_score.setSize(score_width * ratio, score_height * ratio);
		
		
		play_again_button = new Sprite(game.game.assets.play_again);
		play_again_button.setSize(play_again_width*ratio, play_again_height*ratio);
		game.game.spriteCenter(play_again_button);
		play_again_button.setY(200*ratio);
		
		game_over = new Sprite(game.game.assets.game_over);
		game.game.spriteCenter(game_over);
		game_over.setY(LetThemIn.GAME_HEIGHT-game_over.getHeight()- 50*ratio);
		
		voiceButton = new Sprite(game.game.assets.voice_on);
		if(game.game.voice_state){
			voiceButton.setTexture(game.game.assets.voice_off);
		}
		voiceButton.setSize(voice_width*ratio,voice_height*ratio);
		voiceButton.setPosition(play_again_button.getX()+20*ratio,play_again_button.getY() - (voice_height+20)*ratio);
		
		
		
		high_score.setPosition(20*ratio, play_again_button.getY()+play_again_button.getHeight() + 20*ratio);
		your_score.setPosition(20*ratio, high_score.getY() +high_score.getHeight() + 10*ratio);
		
		return_to_menu = new Sprite(game.game.assets.return_to_menu);
		return_to_menu.setSize((int)(120*ratio), (int)(40*ratio));
		return_to_menu.setPosition(0,your_score.getY() + your_score.getHeight() + 10);
		
		
	}
	
	public void render(){
		for(int y=0; y<=LetThemIn.GAME_HEIGHT/32; y++){
			for(int x=0; x<=LetThemIn.GAME_WIDTH/32;x++){
				game.game.batch.draw(game.game.assets.shade,x*32,y*32);
			}
		
		}
		
		
	
		
		play_again_button.draw(game.game.batch);
		//game_over.draw(game.game.batch);
		
		
		
		
		
		
		
		game.game.white_font_48.setColor( Color.WHITE);
		
		
		game.game.white_font_48.draw(game.game.batch,""+game.score, your_score.getX() + score_width * ratio + 5*ratio,your_score.getY() + 	score_height*ratio -5*ratio);
		
	
		
		if(is_h_score){game.game.white_font_48.setColor(Color.RED);}else{game.game.white_font_48.setColor(Color.WHITE);}
		game.game.white_font_48.draw(game.game.batch," "+game.high_score, high_score.getX() + score_width * ratio + 5*ratio,high_score.getY() +	score_height*ratio - 5*ratio);
		game.game.white_font_48.setColor(Color.WHITE);
		
		voiceButton.draw(game.game.batch);
		high_score.draw(game.game.batch);
		your_score.draw(game.game.batch);
		return_to_menu.draw(game.game.batch);
		
	
		
	}

	public void update(){
	
        	 
        	 if(game.game.voice_state){
        		 
        		 voiceButton.setTexture(game.game.assets.voice_off);
        	 }else{
        		
        		 voiceButton.setTexture(game.game.assets.voice_on);
        	 }
         
       
		
		if(game.game_active){
			game.game_active=false;
			game.game.share.handleMessage(1);
			
		
			
			game.game.dataManager.Set_achie_gate_count(game.achie.gate_count + game.game.gateChanges);
			game.game.gateChanges =0;
			
			game.game.dataManager.Set_achie_gate_count(game.game.dataManager.Get_achie_gate_count()+game.game.gateChanges);
			game.game.gateChanges=0;
			
			game.game.dataManager.Set_achie_letin_count(game.game.dataManager.Get_achie_letin_count()+game.score);
			
			if(game.score>game.high_score){
				game.game.dataManager.setHScore(game.score);
				game.high_score=game.game.dataManager.getHScore();
				is_h_score= true;
			
			}
		}
	     Vector3 touchPoint=new Vector3();
	        
	        if(Gdx.input.justTouched())
	        {
	         game.camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
	         if(play_again_button.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
	          {
	        	 game.game.game_count++;
	        	 game.game.share.handleMessage(0);
	        	 if(game.game.game_count % 3 == 0 ){
	        		 game.game.share.handleMessage(4);
	        		 game.game.game_count =0;
	        	 }
	        	 game.game.setScreen(new GameScreen(game.game));
	          
	          }
	         
	         if(voiceButton.getBoundingRectangle().contains(touchPoint.x,touchPoint.y)){
	         	
	        	 game.game.toggleVoice();
	        	 
	        	 if(!game.game.voice_state){
	        		 game.game.assets.bg_music.play();
	        		 voiceButton.setTexture(game.game.assets.voice_on);
	        	 }else{
	        		 game.game.assets.bg_music.pause();
	        		 voiceButton.setTexture(game.game.assets.voice_off);
	        	 }
	         
	         }
	         
	         if(return_to_menu.getBoundingRectangle().contains(touchPoint.x,touchPoint.y)){
	        	 game.game.share.handleMessage(0);
	        	 
	        	 
	        	game.game.setScreen(new MainMenuScreen(game.game));
	        	game.game.assets.bg_music.pause();
	        	
	         
	         }
	         }
	}
	public void load(){

		play_again_button.setTexture(game.game.assets.play_again);
		game_over.setTexture(game.game.assets.game_over);
	}
	
}
