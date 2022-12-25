package com.mygdx.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.ArrayList;
import java.util.Arrays;


public class Main extends ApplicationAdapter {
	// Creating Variables

	SpriteBatch batch;
	ArrayList<MyActor> A;
	MyInputProcessor inputProcessor;
	public Stage stage;


	@Override
	public void create () {
		batch = new SpriteBatch();

		stage = new Stage();
		A = new ArrayList<>(Arrays.asList(new MyActor("/Users/sgupta11/Desktop/Chess/Assets/wPawn.png", 100, 100)));
		A.get(0).setBounds(0, 0, A.get(0).texture().getWidth(), A.get(0).texture().getHeight());

		A.get(0).setTouchable(Touchable.enabled);

		stage.addActor(A.get(0));

		inputProcessor = new MyInputProcessor(A, stage);
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
