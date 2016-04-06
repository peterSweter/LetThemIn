package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class Assets {
	
	public AssetManager manager;
	private String folder;
	
	
	//muzyka
	public Music bg_music;
	
	//game assets
	public Texture background;
	public Texture line;
	public Texture good_guy;

	public Texture bad_guy;
	public Texture gate;
	public Texture shade;
	public Texture open_gate;
	public Texture line_2;
	public Texture pause;
	
	public Texture bg_2;
	
	//pause assets
	public Texture continue_button;
	public Texture voice_on;
	public Texture voice_off;
	
	//menu assets
	
	public Texture tittle;
	public Texture play_button;
	public Texture peter_sweter;
	public Texture how_to_play_button;
	public Texture share_fb_button;
	public Texture music_by;
	public Texture achievements;
	
	//game_over assets
	
	public Texture play_again;
	public Texture game_over;
	public Texture high_score, your_score;
	
	//how to play assets
	
	public Texture slides[];
	
	// achievments 
	public Texture new_alert;
	public Texture score_textures[];
	public Texture letin_textures[];
	public Texture play_textures[];
	public Texture gate_textures[];
	public Texture kurtyna;
	
	public Texture go_back;
	public Texture return_to_menu;
	
	
	public Assets(){
		
		//muzyka
		slides = new Texture[6];
		score_textures= new Texture[7];
		letin_textures= new Texture[4];
		play_textures= new Texture[5];
		gate_textures = new Texture[5];
		
		bg_music = Gdx.audio.newMusic(Gdx.files.internal("di-evantile_charming-life.mp3"));
		bg_music.setVolume(0.5f);                 // sets the volume to half the maximum volume
		bg_music.setLooping(true); 
		
		manager = new AssetManager();
		manager.setLoader(Texture.class, new TextureLoader(null));
		
		if(Gdx.graphics.getWidth()<=320){
			folder="small";
		}else{
			folder="normal";
		}
		
		load();
		Texture.setAssetManager(manager);
		
		
		
		
		
		
		
	}
	
	
	public void load(){
		
	
		//game characters & bg staff
		
		good_guy= new Texture(folder+"/good_guy.png");
		bad_guy= new Texture(folder+"/bad_guy.png");
		gate= new Texture(folder+"/gate.png");
		open_gate= new Texture(folder+"/open_gate.png");
		
		background= new Texture(folder+"/background.png");
		line= new Texture(folder+"/game_line.png");
		line_2= new Texture(folder+"/game_line_2.png");
		shade = new Texture(folder+"/shade.png");
		pause = new Texture(folder+"/pause.png");
	
		
		bg_2= new Texture("bg_2.png");
		//pause assets
		continue_button =new Texture(folder+"/continue_button.png");
		voice_on =new Texture(folder+"/voice_on.png");
		voice_off = new Texture(folder+"/voice_off.png");
		
		//menu assets
		tittle = new Texture(folder+"/menu_tittle.png");
		play_button =new Texture(folder+"/menu_play_button.png");
		peter_sweter = new Texture(folder+"/peter_sweter.png");
		share_fb_button = new Texture(folder+"/share.png");
		how_to_play_button =  new Texture(folder+"/how_to_play.png");
		music_by = new Texture(folder+"/music_by.png");
		achievements = new Texture(folder+"/achievements.png");
		
				
		//game_over assets
				
		play_again = new Texture(folder+"/play_again_button_2.png");
		game_over =  new Texture(folder+"/game_over.png");
		
		your_score =  new Texture(folder+"/your_score.png");
		high_score =  new Texture(folder+"/high_score.png");
		
		//how to play assets
		
		slides[0]= new Texture(folder+"/how_to/slide_1.png");
		slides[1]= new Texture(folder+"/how_to/slide_2.png");
		slides[2]= new Texture(folder+"/how_to/slide_3.png");
		slides[3]= new Texture(folder+"/how_to/slide_4.png");
		slides[4]= new Texture(folder+"/how_to/slide_5.png");
		slides[5]= new Texture(folder+"/how_to/slide_6.png");
		
		score_textures[0] = new Texture("achiev/score_1.png");
		score_textures[1] = new Texture("achiev/score_2.png");
		score_textures[2] = new Texture("achiev/score_3.png");
		score_textures[3] = new Texture("achiev/score_4.png");
		score_textures[4] = new Texture("achiev/score_5.png");
		score_textures[5] = new Texture("achiev/score_6.png");
		score_textures[6] = new Texture("achiev/score_7.png");
		
		
		letin_textures[0] = new Texture("achiev/letin_1.png");
		letin_textures[1] = new Texture("achiev/letin_2.png");
		letin_textures[2] = new Texture("achiev/letin_3.png");
		letin_textures[3] = new Texture("achiev/letin_4.png");
		
		play_textures[0] = new Texture("achiev/play_1.png");
		play_textures[1] = new Texture("achiev/play_2.png");
		play_textures[2] = new Texture("achiev/play_3.png");
		play_textures[3] = new Texture("achiev/play_4.png");
		play_textures[4] = new Texture("achiev/play_5.png");
		
		gate_textures[0] = new Texture("achiev/gate_1.png");
		gate_textures[1] = new Texture("achiev/gate_2.png");
		gate_textures[2] = new Texture("achiev/gate_3.png");
		gate_textures[3] = new Texture("achiev/gate_4.png");
		gate_textures[4] = new Texture("achiev/gate_5.png");
		
		
		new_alert = new Texture("achiev/new.png");
		kurtyna = new Texture("achiev/kurtyna.png");
		
		go_back = new Texture("achiev/go_back.png");
		return_to_menu = new Texture("return_to_menu.png");
		
		manager.load(folder+"/play_again_button_2.png",Texture.class);
		manager.load(folder+"/game_over.png",Texture.class);
		
		manager.load(folder+"/good_guy.png",Texture.class);
		manager.load(folder+"/bad_guy.png",Texture.class);
		manager.load(folder+"/open_gate.png",Texture.class);
		manager.load(folder+"/background.png",Texture.class);
		manager.load(folder+"/game_line.png",Texture.class);
		manager.load(folder+"/game_line_2.png",Texture.class);
		manager.load(folder+"/shade.png",Texture.class);
		manager.load(folder+"/pause.png",Texture.class);
		manager.load(folder+"/voice_on.png",Texture.class);
		manager.load(folder+"/voice_off.png",Texture.class);
		manager.load("bg_2.png",Texture.class);
		
		manager.load(folder+"/menu_tittle.png",Texture.class);
		manager.load(folder+"/menu_play_button.png",Texture.class);
		manager.load(folder+"/peter_sweter.png",Texture.class);
		manager.load(folder+"/share.png",Texture.class);
		manager.load(folder+"/how_to_play.png",Texture.class);
		manager.load(folder+"/achievements.png",Texture.class);
		
		manager.load(folder+"/your_score.png", Texture.class);
		manager.load(folder+"/high_score.png", Texture.class);
		
		manager.load(folder+"/how_to/slide_1.png",Texture.class);
		manager.load(folder+"/how_to/slide_2.png",Texture.class);
		manager.load(folder+"/how_to/slide_3.png",Texture.class);
		manager.load(folder+"/how_to/slide_4.png",Texture.class);
		manager.load(folder+"/how_to/slide_5.png",Texture.class);
		manager.load(folder+"/how_to/slide_6.png",Texture.class);
		
		
		manager.load(folder+"/music_by.png",Texture.class);
		
		manager.load("achiev/score_1.png",Texture.class);
		manager.load("achiev/score_2.png",Texture.class);
		manager.load("achiev/score_3.png",Texture.class);
		manager.load("achiev/score_4.png",Texture.class);
		manager.load("achiev/score_5.png",Texture.class);
		manager.load("achiev/score_6.png",Texture.class);
		manager.load("achiev/score_7.png",Texture.class);
		manager.load("achiev/new.png",Texture.class);
		
		manager.load("achiev/letin_1.png",Texture.class);
		manager.load("achiev/letin_2.png",Texture.class);
		manager.load("achiev/letin_3.png",Texture.class);
		manager.load("achiev/letin_4.png",Texture.class);
		
		manager.load("achiev/play_1.png",Texture.class);
		manager.load("achiev/play_2.png",Texture.class);
		manager.load("achiev/play_3.png",Texture.class);
		manager.load("achiev/play_4.png",Texture.class);
		manager.load("achiev/play_5.png",Texture.class);
		
		manager.load("achiev/gate_1.png",Texture.class);
		manager.load("achiev/gate_2.png",Texture.class);
		manager.load("achiev/gate_3.png",Texture.class);
		manager.load("achiev/gate_4.png",Texture.class);
		manager.load("achiev/gate_5.png",Texture.class);
		manager.load("achiev/kurtyna.png", Texture.class);
		
		manager.load("achiev/go_back.png", Texture.class);
		manager.load("return_to_menu.png", Texture.class);
	
		
		
		
	
		
		AddTextureFilters();
	
	}
	
	private void AddTextureFilters(){
		
		good_guy.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bad_guy.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		line.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		line_2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		play_again.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		how_to_play_button.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		play_button.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		continue_button.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		share_fb_button.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		achievements.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		voice_on.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		voice_off.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		your_score.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		high_score.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		slides[0].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		slides[1].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		slides[2].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		slides[3].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		slides[4].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		slides[5].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		music_by.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		new_alert.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		score_textures[0].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		score_textures[1].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		score_textures[2].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		score_textures[3].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		score_textures[4].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		score_textures[5].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		score_textures[6].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		letin_textures[0].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		letin_textures[1].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		letin_textures[2].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		letin_textures[3].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		play_textures[0].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		play_textures[1].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		play_textures[2].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		play_textures[3].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		play_textures[4].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		gate_textures[0].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		gate_textures[1].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		gate_textures[2].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		gate_textures[3].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		gate_textures[4].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		kurtyna.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		go_back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		return_to_menu.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		
		
		
		
		
		
	}
	
	public void unload(){
		//game characters & bg staff
		
				good_guy.dispose();
				bad_guy.dispose();
				gate.dispose();
				open_gate.dispose();
				
				background.dispose();
				line.dispose();
				line_2.dispose();
				shade.dispose();
				
				//menu assets
				tittle.dispose();
				play_button.dispose();
				peter_sweter.dispose();
						
				//game_over assets
						
				play_again.dispose();
				game_over.dispose();
				
				
				
				manager.unload(folder+"/good_guy.png");
				manager.unload(folder+"/bad_guy.png");
				manager.unload(folder+"/open_gate.png");
				manager.unload(folder+"/background.png");
				manager.unload(folder+"/game_line.png");
				manager.unload(folder+"/game_line_2.png");
				manager.unload(folder+"/shade.png");
				manager.unload(folder+"/pause.png");
				manager.unload(folder+"/voice_on.png");
				manager.unload(folder+"/voice_off.png");
				manager.unload("bg_2.png");
				
				manager.unload(folder+"/menu_tittle.png");
				manager.unload(folder+"/menu_play_button.png");
				manager.unload(folder+"/peter_sweter.png");
				manager.unload(folder+"/share.png");
				manager.unload(folder+"/how_to_play.png");
				manager.unload(folder+"/achievements.png");
				
				manager.unload(folder+"/play_again_button_2.png");
				manager.unload(folder+"/game_over.png");
				
				manager.unload(folder+"/your_score.png");
				manager.unload(folder+"/high_score.png");
				manager.unload(folder+"/how_to/slide_1.png");
				manager.unload(folder+"/how_to/slide_2.png");
				manager.unload(folder+"/how_to/slide_3.png");
				manager.unload(folder+"/how_to/slide_4.png");
				manager.unload(folder+"/how_to/slide_5.png");
				manager.unload(folder+"/how_to/slide_6.png");
				manager.unload(folder+"/music_by.png");
				
				manager.unload("achiev/score_1.png");
				manager.unload("achiev/score_2.png");
				manager.unload("achiev/score_3.png");
				manager.unload("achiev/score_4.png");
				manager.unload("achiev/score_5.png");
				manager.unload("achiev/score_6.png");
				manager.unload("achiev/score_7.png");
				manager.unload("achiev/new.png");
				
				manager.unload("achiev/letin_1.png");
				manager.unload("achiev/letin_2.png");
				manager.unload("achiev/letin_3.png");
				manager.unload("achiev/letin_4.png");
				
				manager.unload("achiev/play_1.png");
				manager.unload("achiev/play_2.png");
				manager.unload("achiev/play_3.png");
				manager.unload("achiev/play_4.png");
				manager.unload("achiev/play_5.png");
				
				manager.unload("achiev/gate_1.png");
				manager.unload("achiev/gate_2.png");
				manager.unload("achiev/gate_3.png");
				manager.unload("achiev/gate_4.png");
				manager.unload("achiev/gate_5.png");
				manager.unload("achiev/kurtyna.png");
				manager.unload("achiev/go_back.png");
				
				manager.unload("return_to_menu.png");
				
				
				
				
		
	}
	

}