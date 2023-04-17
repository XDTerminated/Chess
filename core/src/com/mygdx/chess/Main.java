package com.mygdx.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
public class Main extends ApplicationAdapter {
	// Creating Variables
	SpriteBatch batch;
	MyActor[] whitePieces;
	MyActor[] blackPieces;
	MyActor[][] chessBoard;
	MyInputProcessor inputProcessor;
	public Stage stage;

	// Creates sprites
	@Override
	public void create () {
		ChessBoard.createPieces();

		batch = new SpriteBatch();
		stage = new Stage();

		whitePieces = ChessBoard.getWhitePieces();
		blackPieces = ChessBoard.getBlackPieces();
		chessBoard = ChessBoard.getChessBoard();

		for (MyActor a : whitePieces) {
			stage.addActor(a);
		}

		for (MyActor a : blackPieces) {
			stage.addActor(a);
		}

		inputProcessor = new MyInputProcessor(whitePieces, blackPieces, chessBoard, stage);
		Gdx.input.setInputProcessor(inputProcessor);
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
