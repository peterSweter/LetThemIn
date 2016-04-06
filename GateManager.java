package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;


public class GateManager {
	private LetThemIn game;
	public Gate[] gates;
	GameScreen gs;
	
	public GateManager(LetThemIn game, GameScreen gs){
		this.gs=gs;
		this.game=game;
		
		gates = new Gate[4];
		for(int i=0; i <4; i++){
			gates[i] = new Gate(game,i*LetThemIn.GATE_WIDTH,0);
		}
		
	}
	
	public void render(){
		for(int i =0; i <4; i++){
			if(gates[i].isClose){
				gates[i].render(true);
			}else{
				gates[i].render(false);
			}
		}
	}
	
	public void update(){
		
	}
	
	public void touchAction(int x, int y){
		
		if(y >  gs.pauseManager.pauseButton.getY() ){
			return;
		}
		
		if(x> LetThemIn.GAME_WIDTH/4 * 3){
			toogleGate(3);
		}else if(x> LetThemIn.GAME_WIDTH/4 * 2){
			toogleGate(2);
		}else if(x> LetThemIn.GAME_WIDTH/4 * 1){
			toogleGate(1);
		}else{
			toogleGate(0);
		}
		
	}
	
	public void toogleGate(int id){
		
		game.gateChanges++;
		if(gates[id].isClose){
			gates[id].isClose =false;
		}else{
			gates[id].isClose =true;
		}
		
	}
}
