package com.mygdx.letthemin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class MyInputProcessor implements InputProcessor {
	private GameScreen game;
	 Vector3 touchPoint;
	
	public MyInputProcessor(GameScreen game){
		touchPoint=new Vector3();
		this.game = game;
		
	}
	   @Override
	   public boolean keyDown (int keycode) {
	      return false;
	   }

	   @Override
	   public boolean keyUp (int keycode) {
	      return false;
	   }

	   @Override
	   public boolean keyTyped (char character) {
	      return false;
	   }

	   @Override
	   public boolean touchDown (int x, int y, int pointer, int button) {
		  
		   game.camera.unproject(touchPoint.set(Gdx.input.getX(pointer),Gdx.input.getY(pointer),0));
		  if(GameScreen.game_state == 1) game.gate.touchAction( (int)touchPoint.x, (int)touchPoint.y);
		   return true;
	   }

	   @Override
	   public boolean touchUp (int x, int y, int pointer, int button) {
	      return false;
	   }

	   @Override
	   public boolean touchDragged (int x, int y, int pointer) {
	      return false;
	   }

	   @Override
	   public boolean mouseMoved (int x, int y) {
	      return false;
	   }

	   @Override
	   public boolean scrolled (int amount) {
	      return false;
	   }
	}