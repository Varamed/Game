package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.game.GameScreen;
import com.mygdx.game.handlers.FacebookHandler;
import com.mygdx.game.handlers.GameServicesHandler;
import com.mygdx.game.handlers.RequestHandler;
import com.mygdx.game.screens.Screens;

public class MainShark extends Game {

	public final GameServicesHandler gameServiceHandler;
	public final RequestHandler reqHandler;
	public final FacebookHandler facebookHandler;

	public Stage stage;
	public SpriteBatch batcher;

	public MainShark(RequestHandler reqHandler, GameServicesHandler gameServiceHandler, FacebookHandler facebookHandler) {
		this.reqHandler = reqHandler;
		this.gameServiceHandler = gameServiceHandler;
		this.facebookHandler = facebookHandler;
	}

	@Override
	public void create() {

		batcher = new SpriteBatch();
		stage = new Stage(new StretchViewport(Screens.SCREEN_WIDTH, Screens.SCREEN_HEIGHT));

		Settings.load();
		Assets.load();
		Achievements.init(this);
		setScreen(new GameScreen(this, true));

	}

}
