package com.hugovs.zombiekill;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hugovs.zombiekill.screens.GameScreen;

public class ZombieKill extends Game {

	private Screen screen;

	@Override
	public void create () {
		screen = new GameScreen();
		setScreen(screen);
	}

	@Override
	public void dispose() {
		screen.dispose();
	}
}
