package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HowToPlay implements Screen {
	
	public LetThemIn game;
	private Background bg;
	
	OrthographicCamera camera;
	public Viewport viewport;
	
	public int frames =6;
	public long frame_last = 3000;
	public int ix = 0;
	public long  last_time;
	public boolean where_go;
	
	public HowToPlay(LetThemIn game, boolean where_go){
		
		this.game = game;
		this.where_go=where_go;
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, LetThemIn.GAME_WIDTH, LetThemIn.GAME_HEIGHT);
		viewport = new FitViewport(LetThemIn.GAME_WIDTH,LetThemIn.GAME_HEIGHT);
		
		bg= new Background(game);
		
		last_time =  TimeUtils.millis();
	}
	
	public void update(){
		
		if(TimeUtils.millis()- last_time > frame_last){
			ix++;
			last_time = TimeUtils.millis();
			
			if(ix == 6){
				
				if(where_go){
				game.setScreen(new MainMenuScreen(game));
				 dispose();
				}else{
					game.setScreen(new GameScreen(game));
					 dispose();
					
				}
			}
		}
		
		
	}
	
	@Override
	public void render(float delta) {
		 	Gdx.gl.glClearColor(1.0f, (202/255), (55/255), 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        
	        update();
	        camera.update();
	        game.batch.setProjectionMatrix(camera.combined);
	        
	        game.batch.begin();
	        
	        bg.render();
	       
	        Gdx.graphics.getWidth();
	     if(ix <=5) game.batch.draw(game.assets.slides[ix], 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
	      
	        game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		viewport.update(width, height);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		game.assets.unload();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		game.assets.load();
	
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		
	}

}
