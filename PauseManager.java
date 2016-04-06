package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

public class PauseManager {
	
	private GameScreen gameScreen;
	private float ratio;
	
	public Sprite pauseButton;
	public Sprite continueButton;
	public Sprite voiceButton;
	
	public int width = 40;
	public int height= 40;
	
	
	private int continue_width =280;
	private int continue_height =60;
	
	public int voice_width =40;
	public int voice_height =40;
	
	public PauseManager(GameScreen gameScreen){
		
		ratio = gameScreen.game.ratio;
		this.gameScreen = gameScreen;
		
		pauseButton = new Sprite(gameScreen.game.assets.pause);
		pauseButton.setSize(width*ratio, height*ratio);
		pauseButton.setPosition(Gdx.graphics.getWidth() - (width)*ratio, Gdx.graphics.getHeight() -( height)*ratio);
		
		continueButton =new Sprite(gameScreen.game.assets.continue_button);
		continueButton.setSize(continue_width*ratio, continue_height*ratio);
		gameScreen.game.spriteCenter(continueButton);
		gameScreen.game.spriteVerticalCenter(continueButton);
		
		voiceButton = new Sprite(gameScreen.game.assets.voice_on);
		if(gameScreen.game.voice_state){
			voiceButton.setTexture(gameScreen.game.assets.voice_off);
		}
		voiceButton.setSize(voice_width*ratio,voice_height*ratio);
		voiceButton.setPosition(continueButton.getX()+20*ratio,continueButton.getY() - (voice_height+20)*ratio);
	}
	
	public void update(){
		
		Vector3 touchPoint=new Vector3();
        
        
		if(Gdx.input.justTouched())
        {
         gameScreen.camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
         if(pauseButton.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
          {
        	 gameScreen.guyManager.pause();
        	 gameScreen.game_state = 2;
          
          }
         }
		
		
		
	}
	
	public void pauseUpdate(){
		
		Vector3 touchPoint=new Vector3();
		
		if(Gdx.input.justTouched())
        {
         gameScreen.camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
         if(continueButton.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
          {
        	 gameScreen.game_state = 1;
        	 gameScreen.guyManager.restart();
          
          }
         if(voiceButton.getBoundingRectangle().contains(touchPoint.x,touchPoint.y)){
        	
        	 gameScreen.game.toggleVoice();
        	 
        	 if(!gameScreen.game.voice_state){
        		 gameScreen.game.assets.bg_music.play();
        		 voiceButton.setTexture(gameScreen.game.assets.voice_on);
        	 }else{
        		 gameScreen.game.assets.bg_music.pause();
        		 voiceButton.setTexture(gameScreen.game.assets.voice_off);
        	 }
         
         }
         
         
         }
	}
	
	public void render(){
		pauseButton.draw(gameScreen.game.batch);
	}
	
	public void pauseRender(){
		
		for(int y=0; y<=LetThemIn.GAME_HEIGHT/32; y++){
			for(int x=0; x<=LetThemIn.GAME_WIDTH/32;x++){
				gameScreen.game.batch.draw(gameScreen.game.assets.shade,x*32,y*32);
			}
		
		}
		
		continueButton.draw(gameScreen.game.batch);
		voiceButton.draw(gameScreen.game.batch);
		
		
	}
}
