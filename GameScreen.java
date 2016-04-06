package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
	public LetThemIn game;
	
	//settings variables

	
	private Background bg;
	public GateManager gate;
	public GuyManager guyManager;
	public static int game_state; //1 normalna gra 2 pause 3 game over 
	public  int score;
	public PlayAgain playAgain;
	public ScoreManager scoreManager;
	public boolean game_active;
	public int high_score;
	public PauseManager pauseManager;
	public int play_count;
	
	public Achie achie;
	
	 OrthographicCamera camera;
	 public Viewport viewport;
	 MyInputProcessor inputProcessor;
	
	public GameScreen(final LetThemIn game){
		this.game= game;
		this.game_state=1;
		
		achie = new Achie(this);
		
		inputProcessor = new MyInputProcessor(this);
		Gdx.input.setInputProcessor(inputProcessor);
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, LetThemIn.GAME_WIDTH, LetThemIn.GAME_HEIGHT);
		viewport = new FitViewport(LetThemIn.GAME_WIDTH,LetThemIn.GAME_HEIGHT);
		
        
		score=0;
		
		game.dataManager.Set_achie_play_count(game.dataManager.Get_achie_play_count()+1);
		play_count = game.dataManager.Get_achie_play_count();
		bg= new Background(game);
		gate = new GateManager(game,this);
		guyManager = new GuyManager(game,this);
		playAgain = new PlayAgain(this);
		scoreManager = new ScoreManager(this);
		pauseManager = new PauseManager(this);
		
		high_score = game.dataManager.getHScore();
		
	
       if(!game.dataManager.getVoice()) game.assets.bg_music.play();
        
	}

	@Override
	public void render(float delta) {
		 Gdx.gl.glClearColor(1.0f, (202/255), (55/255), 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	        camera.update();
	        game.batch.setProjectionMatrix(camera.combined);
	        
	        update(delta);
	        
	        game.batch.begin();
	        
	        bg.render();
	        gate.render();
	        guyManager.render(delta);
	        scoreManager.render();
	        pauseManager.render();
	        achie.game_render();
	        
	        if(game_state==3){
	        	playAgain.update();
	        	playAgain.render();
	        
	        }
	        
	        if(game_state==2){
	        	pauseManager.pauseRender();
	        }
	        
	       // game.font.draw(game.batch, "Tutaj siê zaczyna gierka ziomeczku ", 100, 150);
	      
	        game.batch.end();
		
	}
	
	public void update(float delta){
		switch(game_state){
			
			case 1:
				
				gate.update();
				guyManager.update(delta);
				pauseManager.update();
				game_active=true;
				achie.game_update();
				
			break;
			
			case 2:
				//pauza gry
				pauseManager.pauseUpdate();
			break;
			case 3:
				//koniec gry
				
			break;
		}
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		
	}

	@Override
	public void show() {
	
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		if(game_state==1)guyManager.pause();
		
    	
		game.assets.unload();
		
		
	}

	@Override
	public void resume() {
		game.assets.load();
		if(game_state==1){game_state=2;}
		playAgain.load();
		
		
	}

	@Override
	public void dispose() {
		game.assets.unload();
		
	}

}
