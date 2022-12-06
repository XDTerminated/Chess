package com.mygdx.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Main extends ApplicationAdapter {
	// Creating Variables
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		ChessBoard.createChessBoard();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
