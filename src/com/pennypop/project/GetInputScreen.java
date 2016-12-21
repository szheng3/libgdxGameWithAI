/**
 * @author: Shuai Zheng
 */
package com.pennypop.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GetInputScreen implements Screen, TextInputListener {

	/**
	 * 
	 */
	private final Stage stage;
	private final SpriteBatch spriteBatch;
	private Game game;
	private String text;
	private int Option;
	private GameScreen screen;
	private int col;
	private int row;
	private int AiorNot;
	private int flaggam;
	private int Counterwin;

	public GetInputScreen(Game game) {
		spriteBatch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, spriteBatch);
		this.game = game;
		Option = 0;

		flaggam = 0;

	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		stage.dispose();
	}

	@Override
	public void render(float delta) {
		if (Option == 0) {
			Gdx.input.getTextInput(this, "Row", "6");
			Option++;

		} else if (Option == 2) {
			Gdx.input.getTextInput(this, "Column", "7");
			Option++;

		} else if (Option == 4) {

			Gdx.input.getTextInput(this, "CountToWin", "4");
			Option++;

		} else if (Option == 6) {

			Gdx.input.getTextInput(this, "1:Play With AI, 2:Single Two Player Game", "1");
			Option++;

		} else if (Option == 8) {
			Gdx.input.setInputProcessor(null);

			screen = new GameScreen(game, col, row, AiorNot, Counterwin);
			game.setScreen(screen);
			Option++;
			flaggam = 1;

		}

		if (flaggam == 1) {
			clearWhite();
			screen.render(delta);
		}
		stage.act(delta);
		stage.draw();
	}

	private void clearWhite() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, false);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void pause() {
		// Irrelevant on desktop, ignore this
	}

	@Override
	public void resume() {
		// Irrelevant on desktop, ignore this
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Input.TextInputListener#canceled()
	 */
	@Override
	public void canceled() {
		// TODO Auto-generated method stub
		Option = 0;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Input.TextInputListener#input(java.lang.String)
	 */
	@Override
	public void input(String arg0) {
		// TODO Auto-generated method stub
		this.text = arg0;
		// System.out.println(text);
		if (Option == 1) {
			this.row = Integer.parseInt(text);
			System.out.println(row);

		} else if (Option == 3) {
			this.col = Integer.parseInt(text);
			System.out.println(col);

		} else if (Option == 5) {
			this.Counterwin = Integer.parseInt(text);

		} else if (Option == 7) {

			this.AiorNot = Integer.parseInt(text);
			System.out.println(AiorNot);

		}
		this.Option = Option + 1;

	}

}
