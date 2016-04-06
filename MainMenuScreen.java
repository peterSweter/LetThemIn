package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
	
public class MainMenuScreen implements Screen {
	
	
	
	final LetThemIn game;
	OrthographicCamera camera;
	public Background background;
	
	public Sprite play_button_sprite;
	public Sprite how_to_play_button;
	public Sprite share_fb_button;
	public Sprite achievements_button;
	public Sprite high_score;
	
	public Sprite tittle;
	
	public int button_width = 260;
	public int button_height = 60;
	public int score_width = 180;
	public int score_height = 40;
	public int high_score_v;
	
	public MainMenuScreen(final LetThemIn game){
		this.game = game;
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, LetThemIn.GAME_WIDTH, LetThemIn.GAME_HEIGHT);
	    
	    background= new Background(game);
	    
	    play_button_sprite = new Sprite(game.assets.play_button);
	    play_button_sprite.setSize(button_width*game.ratio, button_height*game.ratio);
	   
	    
	    play_button_sprite.setPosition((int)(LetThemIn.GAME_WIDTH - play_button_sprite.getWidth())/2,250*game.ratio);
	    
	    how_to_play_button = new Sprite(game.assets.how_to_play_button);
	    how_to_play_button.setSize(button_width*game.ratio, button_height*game.ratio);
	    how_to_play_button.setPosition((int)(LetThemIn.GAME_WIDTH - play_button_sprite.getWidth())/2,play_button_sprite.getY() - 10*game.ratio - button_height*game.ratio);
	    
	    
	    achievements_button = new Sprite(game.assets.achievements);
	    achievements_button.setSize(button_width*game.ratio, button_height*game.ratio);
	    achievements_button.setPosition((int)(LetThemIn.GAME_WIDTH - play_button_sprite.getWidth())/2,how_to_play_button.getY() - 10*game.ratio - button_height*game.ratio);
	  
	    
	   tittle = new Sprite(game.assets.tittle);
	   tittle.setSize(284*game.ratio,59*game.ratio);
	   game.spriteCenter(tittle);
	   tittle.setY(LetThemIn.GAME_HEIGHT-70*game.ratio);
	   
	   high_score_v = game.dataManager.getHScore();
	   
	   high_score = new Sprite(game.assets.high_score);
	   high_score.setSize(score_width * game.ratio, score_height * game.ratio);
	   high_score.setPosition(play_button_sprite.getX(), play_button_sprite.getY() + play_button_sprite.getHeight() + 5*game.ratio);
	   
	  
	   
	}

    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0.43f, 0.7f, 1.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        	background.menuRender();
        
        	play_button_sprite.draw(game.batch);
        	how_to_play_button.draw(game.batch);
        	achievements_button.draw(game.batch);
        	high_score.draw(game.batch);
        	tittle.draw(game.batch);
        	
        game.white_font_48.draw(game.batch," "+high_score_v, high_score.getX() + score_width * game.ratio + 5* game.ratio,high_score.getY() +	score_height*game.ratio - 5*game.ratio);
        	
        	//renderCenter(game.assets.play_button,LetThemIn.GAME_HEIGHT-166);
        	game.batch.draw(game.assets.peter_sweter,Gdx.graphics.getWidth() - game.assets.peter_sweter.getWidth() , 5,game.assets.peter_sweter.getWidth() , game.assets.peter_sweter.getHeight()  );
        	game.batch.draw(game.assets.music_by,10 , 5, game.assets.peter_sweter.getWidth()  , game.assets.peter_sweter.getHeight()  );
        
        game.batch.end();
        
        Vector3 touchPoint=new Vector3();
        
        if(Gdx.input.justTouched())
        {
	         camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
	         if(play_button_sprite.getBoundingRectangle().contains(touchPoint.x,touchPoint.y)){
	        	 
	        	
	        	
	        	
	        	 if(game.dataManager.getFirstTime()){
	        	 	game.setScreen(new GameScreen(game));
	        	 	dispose();
	        	 }else{
	        		 
	        		 game.dataManager.setFirstTime();
	        		 
	        		 game.dataManager.SetAchieValues();
	        		 	game.setScreen(new GameScreen(game));
	        		 game.setScreen(new HowToPlay(game,false));
		        	 dispose();
	        		 
	        	 }
	          }
	        
	         if(achievements_button.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
	         {
	        	  
	        	 // to  wlacza share gry game.share.handleMessage(3);
	        	 game.setScreen(new AchieScreen(game));
	        	 dispose();
	         }
	        
	         if(how_to_play_button.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
	         {
	        	 game.setScreen(new HowToPlay(game, true));
	        	 
		           dispose();
	         }
	         
	         
         }
        
    }

	@Override
	public void resize(int width, int height) {
	
		achievements_button.setTexture(game.assets.achievements);
	}

	@Override
	public void show() {
		
		achievements_button.setTexture(game.assets.achievements);
	}

	@Override
	public void hide() {
	
	}

	@Override
	public void pause() {
		
		game.assets.unload();
	}

	@Override
	public void resume() {
		game.assets.load();
		
		play_button_sprite.setTexture(game.assets.play_button);
		achievements_button.setTexture(game.assets.achievements);
		 tittle.setTexture(game.assets.tittle);
		
	}

	@Override
	public void dispose() {
		
		
	}
	
	public void renderCenter(Texture texture,int top){
		game.batch.draw(texture, (LetThemIn.GAME_WIDTH - texture.getWidth())/2,top-texture.getHeight());
	}
	

	
}
