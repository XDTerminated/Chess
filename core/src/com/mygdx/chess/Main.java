package com.mygdx.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	// Test comment
	// Creating Variables
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		createChessBoard();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public void createChessBoard() {
		final Color WHITE = new Color(0x9c9c9c);
		final Color BLACK = new Color(0x595959);
		ScreenUtils.clear(252, 252, 252, 252);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
				if ((j + i) % 2 == 1) {
					shapeRenderer.setColor(WHITE);
				} else {
					shapeRenderer.setColor(BLACK);
				}

				shapeRenderer.rect(j * 220, i * 220, 220, 220);
				shapeRenderer.end();
			}
		}
	}

}
