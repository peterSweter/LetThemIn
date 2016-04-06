package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class AchieScreen implements Screen{
	
	
	LetThemIn ltm;
	
	Stage stage;
	Table outerTable;
	Table innerTable;
	ScrollPane scrollPane;
	
	OrthographicCamera camera;
	
	public int score_bound = 7;
	public int letin_bound = 4;
	public int play_bound = 5;
	public int gate_bound = 5;
	
	public int score_state;
	public int letin_state;
	public int play_state;
	public int gate_state;
	
	public int achie_width = (int) (280 * LetThemIn.ratio);
	public int achie_height =  (int) (45 * LetThemIn.ratio);
	
	public int go_back_width = (int) (80 * LetThemIn.ratio);
	public int go_back_height = (int) (30 * LetThemIn.ratio);
	
	public Sprite go_back;
	
	
	public AchieScreen(LetThemIn ltm){
		
		this.ltm = ltm;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, LetThemIn.GAME_WIDTH, LetThemIn.GAME_HEIGHT);
		
		score_state = ltm.dataManager.Get_achie_score_state();
		gate_state = ltm.dataManager.Get_achie_gate_state();
		letin_state = ltm.dataManager.Get_achie_letin_state();
		play_state = ltm.dataManager.Get_achie_play_state();
		
		go_back = new Sprite(ltm.assets.go_back);
		go_back.setSize(go_back_width, go_back_height);
		go_back.setPosition(0,Gdx.graphics.getHeight() - go_back_height);
		
	}
	
	@Override
	public void render(float delta) {
	    Gdx.gl20.glClearColor(0, 0, 0, 1);
	    Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    camera.update();
        ltm.batch.setProjectionMatrix(camera.combined);
        
	    update();
	    stage.act(delta);
	    stage.draw();
	    ltm.batch.begin();
	    go_back.draw(ltm.batch);
	    ltm.batch.end();
	}
	
	public void update(){
		
		 Vector3 touchPoint=new Vector3();
	        
	        if(Gdx.input.justTouched())
	        {
		         camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
		         if(go_back.getBoundingRectangle().contains(touchPoint.x,touchPoint.y)){
		        	 
		        	 ltm.setScreen(new MainMenuScreen(ltm));
		        	 dispose();
		        	
		       
		          }
	        }
		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {

	    stage      = new Stage();
	    Gdx.input.setInputProcessor(stage);
	    outerTable = new Table();
	    innerTable = new Table();
	    
	    //innerTable.add(YourActor); for example Image, or TextButton 
	    
	   
	   
	    
	   
	    for(int i=0;i<score_bound; i++){
	    		
	    	if(i<score_state){
	    	 innerTable.row().width(achie_width).height(achie_height).top();
	    	
	    	 innerTable.add(new Image(ltm.assets.score_textures[i]));
	    	}else{
	    		 
	    		innerTable.row().width(achie_width).height(achie_height).top();
	 	    	
		    	 innerTable.stack(new Image(ltm.assets.score_textures[i]),new Image(ltm.assets.kurtyna));
	    		
	    	}
	    	
	    }
	    
	    for(int i=0;i<letin_bound; i++){
    		
	    	if(i<letin_state){
		    	 innerTable.row().width(achie_width).height(achie_height).top();
		    	
		    	 innerTable.add(new Image(ltm.assets.letin_textures[i]));
		    	}else{
		    		 
		    		innerTable.row().width(achie_width).height(achie_height).top();
		 	    	
			    	 innerTable.stack(new Image(ltm.assets.letin_textures[i]),new Image(ltm.assets.kurtyna));
		    		
		    	}
	    	
	    }
	    
	    for(int i=0;i<play_bound; i++){
    		
	    	if(i<play_state){
		    	 innerTable.row().width(achie_width).height(achie_height);
		    	
		    	 innerTable.add(new Image(ltm.assets.play_textures[i]));
		    	}else{
		    		 
		    		innerTable.row().width(achie_width).height(achie_height);
		 	    	
			    	 innerTable.stack(new Image(ltm.assets.play_textures[i]),new Image(ltm.assets.kurtyna));
		    		
		    	}
	    	
	    }
	    
	    for(int i=0;i<gate_bound; i++){
    		
	    	if(i<gate_state){
		    	 innerTable.row().width(achie_width).height(achie_height);
		    	
		    	 innerTable.add(new Image(ltm.assets.gate_textures[i]));
		    	}else{
		    		 
		    		innerTable.row().width(achie_width).height(achie_height);
		 	    	
			    	 innerTable.stack(new Image(ltm.assets.gate_textures[i]),new Image(ltm.assets.kurtyna));
		    		
		    	}
	    	
	    }
	    innerTable.row().width(achie_width).height(achie_height);
	    innerTable.add(new Image(ltm.assets.kurtyna));
	    

	    innerTable.bottom();
	    
	  

	    innerTable.setFillParent(true);
	   
	    scrollPane = new ScrollPane(innerTable); 
	
	  
	    outerTable.setPosition(0, 0);
	    outerTable.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	
	  

	    //outerTable.debug();
	  
	    outerTable.add(scrollPane).fill().expand();
	    
	    outerTable.top();
	    stage.addActor(outerTable);
	   
	    
	    
	
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		
	ltm.assets.unload();
	}

	@Override
	public void resume() {
		ltm.assets.load();
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
