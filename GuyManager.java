package com.mygdx.letthemin;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class GuyManager {
	private LetThemIn game;
	private GameScreen gameScreen;
	
	public Guy[][] guys;
	public long[] last_time;
	public int[] next_time;
	public int[] last_use;
	public int[] next_to_use;
	public long random_time_max = 3000;
	public long random_time_min = 1000;
	public long good_chance = 60; // up to sixty is choosing good circle !
	public  int  speed = (int) (160*LetThemIn.ratio);
	public boolean[] start;
	public int level =0;
	public int last_level_change=-1;
	public int speed_boost_mod=(int) (50 );
	public int random_boost_mod =(int) (10);
	
	public int spawn_space_mod = 50;
	public int spawn_space_max = 8;
	public int spawn_space_min =5;
	
	private boolean speed_active=true;
	private boolean random_active=true;
	private boolean speed_big_active = true;
	private boolean start_boost = true;
	
	public boolean start_control[];
	

	
	
	
	
	public GuyManager(LetThemIn game,GameScreen gameScreen){

		this.game = game;
		this.gameScreen=gameScreen;
		this.guys = new Guy[4][50];
		this.last_time = new long[4];
		this.next_time = new int[4];
		this.last_use = new int[4];
		this.next_to_use = new int[4];
		this.start= new boolean[4];
		
		start_control = new boolean[4];
		start_control[0] = true;
		
		
		for(int i=0; i <4; i++){
			for(int j=0; j <50;j++){
				guys[i][j] = new Guy(game,0);
			}
			
			last_time[i] = TimeUtils.millis();
			next_time[i] = LetThemIn.GAME_HEIGHT - MathUtils.random(spawn_space_min, spawn_space_max)* LetThemIn.GATE_HEIGHT;
			next_to_use[i]=0;
			last_use[i]=0;
			start[i]=false;
			start_control[i] = false;
		}
		start_control[0] = true;
		
	}
	
	public void update(float delta){
		
		for(int i=0;i <4;i++){
			if((guys[i][last_use[i]].y < next_time[i] && (guys[i][last_use[i]].y<LetThemIn.GAME_HEIGHT - LetThemIn.GATE_HEIGHT)) ||(start[i]==false && start_control[i]) ){
				//System.out.println("score bak "+gameScreen.score+"spawn_space_min "+spawn_space_min+" spawn_space_max "+spawn_space_max);
				//System.out.println("speed: "+ speed);
				
				start[i]=true;
				start_control[i]= false;
				
				guys[i][next_to_use[i]].toggle();
				last_use[i] =next_to_use[i];
				guys[i][next_to_use[i]].set(i);
				next_to_use[i]++;
				if(next_to_use[i]>=49)next_to_use[i]=0;
				
				next_time[i] = LetThemIn.GAME_HEIGHT - MathUtils.random(spawn_space_min, spawn_space_max)* LetThemIn.GATE_HEIGHT;
				
				
			}
			
		}
		
		for(int x=0; x<4; x++){
			for(int y=0; y<50; y++){
				if(guys[x][y].active){
					
				
					
					guys[x][y].y-=speed * delta;
					if(guys[x][y].y <= LetThemIn.GAME_HEIGHT/2 && x!=3){
						start_control[x+1]=true;
					}
					
					switch(guys[x][y].type){
						case 1: 
							if(guys[x][y].y<=10 && gameScreen.gate.gates[x].isClose==false ){
								guys[x][y].toggle();
								
								//PLUS PUNKT ZIOMECZKU//
								gameScreen.score+=1;
								
							}else if(guys[x][y].y<= LetThemIn.GATE_HEIGHT && gameScreen.gate.gates[x].isClose==true  ){
								GameScreen.game_state=3;
							}
							//punkt
							break;
						case 2:
							if(guys[x][y].y<=LetThemIn.GATE_HEIGHT && gameScreen.gate.gates[x].isClose ){
								guys[x][y].toggle();
							}else if(guys[x][y].y<=LetThemIn.GATE_HEIGHT){
								GameScreen.game_state=3;
							}
							break;
					}
					
					
				}
				
				
			}
		}
	
		levelManager();
	}
	
	public void render(float delta){
		
		for(int x=0; x<4; x++){
			for(int y=0; y<50; y++){
				if(guys[x][y].active){
					guys[x][y].render(delta);
				}
			}
		}
		
	}
	
	public void levelManager(){
		
		if(gameScreen.score==0 || last_level_change == gameScreen.score )return;
		
		if(gameScreen.score == 100){
			last_level_change =gameScreen.score;
			if(speed_big_active){
				
				speed +=10*LetThemIn.ratio;
				speed_big_active=false;
				speed_boost_mod+=(int)(gameScreen.score/100)*10;
			}
			
		}else{
			speed_big_active = true;
		}
		
		if(gameScreen.score % speed_boost_mod ==0 ){
			if(speed_active){
				speed +=15*LetThemIn.ratio;
				speed_active=false;
				speed_boost_mod+=(int)(gameScreen.score/100)*10;
				
			}else{
				speed_active=true;
			}
			
			last_level_change =gameScreen.score;
			
			
	
		}
		if(gameScreen.score == 25  && start_boost && false){
			//spawn_space_max--;
			spawn_space_min--;
			//speed+=15*LetThemIn.ratio;
			start_boost = false;
		}
		
		if(gameScreen.score % spawn_space_mod == 0 ){
		
			
			if(random_active){
				
				spawn_space_max--;
				spawn_space_min--;
				random_active=false;
				if(gameScreen.score >= 100)spawn_space_mod+=25;
				
				if(spawn_space_min < 1)spawn_space_min=1;
				if(spawn_space_max < 4)spawn_space_max=4;
				
			}else{
				random_active = true;
			}
			last_level_change =gameScreen.score;
		}
		
		if(gameScreen.score % random_boost_mod == 0 && false){
			
			if(random_active){
				random_time_max -=200;
				random_time_min -=50;
				random_active=false;
				random_boost_mod+=(int)(gameScreen.score/50)*10;
			}else{
				random_active = true;
			}
			last_level_change =gameScreen.score;
		}
		
		if(gameScreen.score == 200)speed_boost_mod+=50;
	}
	
	public void restart(){
		for(int i=0; i <4; i++){
		
			
			//next_time[i] += TimeUtils.millis();
		}
	}
	public void pause(){
		for(int i=0; i <4; i++){
		
			
			//next_time[i] -= TimeUtils.millis();
		}
	}
}
