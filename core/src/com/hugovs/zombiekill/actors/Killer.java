package com.hugovs.zombiekill.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Pool;
import com.hugovs.zombiekill.screens.GameScreen;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 21:53<br/>
 */
public class Killer extends Actor {

    private GameScreen screen;

    private InputProcessor inputProcessor;

    public Killer(float x, float y, final GameScreen screen) {

        super(Textures.getInstance().CHARACTER, x, y);
        this.screen = screen;
        setScale(0.7f);

        inputProcessor = new InputAdapter() {

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                setY(Gdx.graphics.getHeight() - screenY);
                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (Gdx.input.justTouched()) {
                    screen.actorHolder.addActor(new Bullet(getX(), getY(), screen));
                    return true;
                }
                return false;
            }

        };

        Gdx.input.setInputProcessor(inputProcessor);

    }

}
