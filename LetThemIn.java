package com.mygdx.letthemin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class LetThemIn extends Game {
	
	
	
	public static int GAME_WIDTH = 320;
	public static int GAME_HEIGHT = 480; 
	public static int GATE_WIDTH =80;
	public static int GATE_HEIGHT =40;
	public static float ratio;
	
	public int game_count=0;
	
	public boolean voice_state ;
	
	public SpriteBatch batch;
	public 	ShaderProgram fontShader;
	public int gateChanges =0;
	
	
	
	public BitmapFont font;
	public Assets assets;
	public BitmapFont black_font_32, black_font_48, white_font_48,test,arial_white_48,georgia_48,impact_white_150;
	public DataManager dataManager;
	
	public Share share;
	
	public LetThemIn(Share share){
		this.share= share;
		
	}
	
	public LetThemIn(){
		
		
	}
	
	@Override
	public void create () {

		
		GAME_WIDTH = Gdx.graphics.getWidth();
		GAME_HEIGHT=Gdx.graphics.getHeight();
		GATE_HEIGHT =(int) GAME_WIDTH/8;
		GATE_WIDTH =GATE_HEIGHT *2;
		
		batch = new SpriteBatch();
		fontShader = new ShaderProgram(Gdx.files.internal("font.vert"), Gdx.files.internal("font.frag"));
		if (!fontShader.isCompiled()) {
		    Gdx.app.error("fontShader", "compilation failed:\n" + fontShader.getLog());
		}
	
		
		font = new BitmapFont();
		assets = new Assets();
		
		georgia_48 =new BitmapFont(Gdx.files.internal("georgia_48.fnt"),false);
		black_font_32=new BitmapFont(Gdx.files.internal("black.fnt"),false);
		black_font_48=new BitmapFont(Gdx.files.internal("black_48.fnt"),false);
		white_font_48=new BitmapFont(Gdx.files.internal("white_48.fnt"),false);
		arial_white_48 = new BitmapFont(Gdx.files.internal("arial_white_48.fnt"),false);
		impact_white_150 = new BitmapFont(Gdx.files.internal("150impact.fnt"),false);
		test = new BitmapFont(Gdx.files.internal("test.fnt"),false);
		test.setScale(.2f);
		
		white_font_48.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		black_font_48.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		test.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		arial_white_48.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		impact_white_150.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		
		impact_white_150.setScale(0.3f);
		
		dataManager= new DataManager();
		ratio = (float)((float)Gdx.graphics.getHeight()/(float)480);
	
	
		white_font_48.setScale((float) ((float)ratio*0.25));
		//georgia_48.setScale((float) ((float)ratio*0.33));
		voice_state = dataManager.getVoice();
		this.setScreen(new MainMenuScreen(this));
		
		//testowania czcionek
		
		//white_font_48 = arial_white_48;
		
	}

	@Override
	public void render () {
		super.render();
	    //Gdx.gl20.glClearColor(0, 0, 0, 1);
	    //Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
	//	System.out.println(ratio);
	}
	
	public void dispose(){
		batch.dispose();
		font.dispose();
	}
	
	public void spriteCenter(Sprite sprite){
		sprite.setX((int)((LetThemIn.GAME_WIDTH-sprite.getWidth())/2));
	}
	public void spriteVerticalCenter(Sprite sprite){
		sprite.setY((int)((LetThemIn.GAME_HEIGHT-sprite.getHeight())/2));
	}
	
	public void toggleVoice(){
		voice_state = !voice_state;
		dataManager.setVoice(voice_state);
	}
	
	
}
