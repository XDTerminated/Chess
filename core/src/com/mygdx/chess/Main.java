package com.mygdx.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;


public class Main extends ApplicationAdapter {
	// Creating Variables

	SpriteBatch batch;
	MyActor A;
	MyInputProcessor inputProcessor;
	Stage stage;
	DragAndDrop dragAndDrop;



	@Override
	public void create () {
		batch = new SpriteBatch();

		dragAndDrop = new DragAndDrop();

		stage = new Stage();
		A = new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 100, 100);
		A.setBounds(0, 0, A.texture().getWidth(), A.texture().getHeight());

		A.setTouchable(Touchable.enabled);

		stage.addActor(A);

		inputProcessor = new MyInputProcessor(A);
		Gdx.input.setInputProcessor(inputProcessor);

	}

	@Override
	public void render () {

		ChessBoard.createChessBoard();

		stage.act();
		stage.draw();
	}


	@Override
	public void dispose () {


	}
}
