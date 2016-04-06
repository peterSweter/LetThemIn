package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class Achie {
	
	public int score_bound = 7;
	public int letin_bound = 4;
	public int play_bound = 5;
	public int gate_bound = 5;
	
	public int pause_width =40;
	
	public int[] score_values;
	public int[] letin_values;
	public int[] play_values;
	public int[] gate_values;
	
	public int score_state;
	public int letin_state;
	public int play_state;
	public int gate_state;
	
	boolean score_show=false;
	long score_show_time;
	
	boolean play_show = false;
	long play_show_time;
	
	boolean gate_show = false;
	long gate_show_time;
	
	boolean letin_show = false;
	long letin_show_time;
	
	long show_last = 4000;
	
	public int achie_width = 280;
	public int achie_height = 45;
	
	public int new_alert_width = 80;
	public int new_alert_height = 15;
	
	public int gate_count;
	public int letin_count;
	
	
	public float ratio;
	
	
	
	public GameScreen gameScreen;
	
	public Achie(GameScreen gameScreen){
		
		this.gameScreen = gameScreen;
		this.ratio = gameScreen.game.ratio;
		
		score_values = new int[7];
		letin_values= new int[4];
		play_values = new int[5];
		gate_values= new int[5];
		
		
		score_values[0] = 25;
		score_values[1] = 50;
		score_values[2] = 100;
		score_values[3] = 200;
		score_values[4] = 300;
		score_values[5] = 400;
		score_values[6] = 500;
		
		letin_values[0] = 100;
		letin_values[1] = 1000;
		letin_values[2] = 5000;
		letin_values[3] = 10000;
		
		play_values[0] = 10;
		play_values[1] = 50;
		play_values[2] = 100;
		play_values[3] = 200;
		play_values[4] = 500;
		
		gate_values[0] = 500;
		gate_values[1] = 1000;
		gate_values[2] = 5000;
		gate_values[3] = 10000;
		gate_values[4] = 1000000;
		
		this.score_state = gameScreen.game.dataManager.Get_achie_score_state();
		this.play_state = gameScreen.game.dataManager.Get_achie_play_state();
		this.gate_state = gameScreen.game.dataManager.Get_achie_gate_state();
		this.letin_state = gameScreen.game.dataManager.Get_achie_letin_state();
		
		gate_count = gameScreen.game.dataManager.Get_achie_gate_count();
		letin_count = gameScreen.game.dataManager.Get_achie_letin_count();
				
	    

				
			
	}
	
	
	public void  game_update(){
		if(score_state < score_bound){
			if(gameScreen.score >= score_values[score_state ] && score_state < score_bound){
				
				score_show = true;
				score_show_time= TimeUtils.millis();
				score_state++;
				gameScreen.game.dataManager.Set_achie_score_state(score_state);
				
				
			}
		}
		
		if(play_state < play_bound){
			if(gameScreen.play_count >= play_values[play_state] && play_state < play_bound ){
				
				play_show = true;
				play_show_time = TimeUtils.millis();
				play_state++;
				gameScreen.game.dataManager.Set_achie_play_state(play_state);
				
				
			}
		}
		if(gate_state < gate_bound){
			if(gate_count + gameScreen.game.gateChanges >=gate_values[gate_state] && gate_state < gate_bound){
				
				gate_show = true;
				gate_show_time = TimeUtils.millis();
				gate_state++;
				gameScreen.game.dataManager.Set_achie_gate_state(gate_state);
			
				
				
			}
		}
		
		if(letin_state < letin_bound){
			if(letin_count + gameScreen.score >= letin_values[letin_state] && letin_state < letin_bound){
				
				letin_show = true;
				letin_show_time = TimeUtils.millis();
				letin_state++;
				gameScreen.game.dataManager.Set_achie_letin_state(gameScreen.achie.letin_state);
			
				
			}
		}
		
		
		
	}
	
	public void game_render(){
		

		int width = (int) (LetThemIn.GAME_WIDTH  - pause_width* 3 * ratio); 
		int height = (int) ((float)achie_height/(float)achie_width * (float)width);
		
		int y = (int) (Gdx.graphics.getHeight() - achie_height*ratio - gameScreen.pauseManager.height* ratio -8 - new_alert_height*ratio);
		int x = (int) ((Gdx.graphics.getWidth() - width)/2) ;
		
		y=(int) (Gdx.graphics.getHeight() - height - (int)new_alert_height*ratio - 4*ratio) ;
		
		int new_width = (int)(new_alert_width*ratio);
		int new_height = (int) (new_alert_height*ratio);
		
		if(score_show ){
		
			
			
			gameScreen.game.batch.draw(gameScreen.game.assets.score_textures[score_state -1], x, y, width, height);
			gameScreen.game.batch.draw(gameScreen.game.assets.new_alert, x, y + (int)( height + 4),new_width , new_height);
			
			if(TimeUtils.millis() - score_show_time > show_last){
				score_show=false;
			}
			
		}
		
		if(play_show  ){
		
			
			
			gameScreen.game.batch.draw(gameScreen.game.assets.play_textures[play_state -1], x, y, width, height);
			gameScreen.game.batch.draw(gameScreen.game.assets.new_alert, x, y + (int)( height + 4),new_width , new_height);
			
			if(TimeUtils.millis() - play_show_time > show_last){
				play_show=false;
			}
			
		}
		
		if(gate_show  ){
		
			
			
			gameScreen.game.batch.draw(gameScreen.game.assets.gate_textures[gate_state -1], x, y, width, height);
			gameScreen.game.batch.draw(gameScreen.game.assets.new_alert, x, y + (int)( height + 4),new_width , new_height);
			
			if(TimeUtils.millis() - gate_show_time > show_last){
				gate_show=false;
			}
			
		}
		
		if(letin_show  ){
		
			
			
			gameScreen.game.batch.draw(gameScreen.game.assets.letin_textures[letin_state -1], x, y, width, height);
			gameScreen.game.batch.draw(gameScreen.game.assets.new_alert, x, y + (int)( height + 4),new_width , new_height);
			
			if(TimeUtils.millis() -letin_show_time > show_last){
				letin_show=false;
			}
			
		}
		
		
		
	}
	
}
