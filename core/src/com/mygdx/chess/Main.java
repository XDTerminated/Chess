package com.mygdx.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
	// Creating Variables
	SpriteBatch batch;
	ArrayList<MyActor> pieces;
	MyInputProcessor inputProcessor;
	public Stage stage;


	// Creates sprites
	@Override
	public void create () {
		batch = new SpriteBatch();
		stage = new Stage();

		pieces = ChessBoard.returnPieces();

		for (MyActor a: pieces) {
			stage.addActor(a);
		}

		inputProcessor = new MyInputProcessor(pieces, stage);
		Gdx.input.setInputProcessor(inputProcessor);

		ChessBoard.setTurn("White");
	}

	// Display on the screen
	@Override
	public void render () {

		ChessBoard.createChessBoard();

		stage.act();
		stage.draw();
	}

	// Dispose
	@Override
	public void dispose () {
		stage.dispose();
		batch.dispose();

	}
}
