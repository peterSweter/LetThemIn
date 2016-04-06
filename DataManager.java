package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class DataManager {
	Preferences prefs;
		public DataManager(){
			 prefs = Gdx.app.getPreferences("My Preferences");
		}

		public void setHScore(int hScore){
			prefs.putInteger("hScore",hScore);
			prefs.flush();
		
		}
		public int getHScore(){
			return  prefs.getInteger("hScore");
		}
		
		public boolean getVoice(){
			
			return prefs.getBoolean("voice_state");
	
		}
		
		public void setVoice(boolean voice_state){
			prefs.putBoolean("voice_state",voice_state);
			prefs.flush();
		}
		
		public void setFirstTime(){
			prefs.putBoolean("first_time", true);
			prefs.flush();
		}
		
		public boolean getFirstTime(){
			return prefs.getBoolean("first_time");
		}
		
		public void SetAchieValues(){
			
			prefs.putInteger("achie_score_state",0);
			prefs.putInteger("achie_letin_state",0);
			prefs.putInteger("achie_gate_state",0);
			prefs.putInteger("achie_play_state",0);
			
			prefs.putInteger("achie_gate_count",0);
			prefs.putInteger("achie_play_count",0);
			prefs.putInteger("achie_letin_count",0);
			prefs.flush();
			
		}
		
		public int Get_achie_score_state(){
			return  prefs.getInteger("achie_score_state");
		
			
		}
		
		public int Get_achie_letin_state(){
			return  prefs.getInteger("achie_letin_state");
			
			
		}
		
		public int Get_achie_gate_state(){
			return  prefs.getInteger("achie_gate_state");
			
		}
		
		public int Get_achie_play_state(){
			return  prefs.getInteger("achie_play_state");
			
		}
		public int Get_achie_gate_count(){
			return  prefs.getInteger("achie_gate_count");
			
		}
		public int Get_achie_play_count(){
			return  prefs.getInteger("achie_play_count");
			
		}
		public int Get_achie_letin_count(){
			return  prefs.getInteger("achie_letin_count");
			
		}
		
		
		public void Set_achie_score_state(int v){
			prefs.putInteger("achie_score_state", v);
			prefs.flush();
			
		}
		
		public void Set_achie_letin_state(int v){
			prefs.putInteger("achie_letin_state", v);
			prefs.flush();
			
		}
		
		public void Set_achie_gate_state(int v){
			prefs.putInteger("achie_gate_state", v);
			prefs.flush();
			
		}
		
		public void Set_achie_gate_count(int v){
			if(v < 2000000)prefs.putInteger("achie_gate_count", v);
			prefs.flush();
			
		}
		
		public void Set_achie_play_state(int v){
			prefs.putInteger("achie_play_state", v);
			prefs.flush();
			
		}
		
		public void Set_achie_play_count(int v){
			if(v < 2000000)prefs.putInteger("achie_play_count", v);
			prefs.flush();
			
		}
		
		public void Set_achie_letin_count(int v){
			if(v < 2000000)prefs.putInteger("achie_letin_count", v);
			prefs.flush();
			
		}
		
		
		
		
}