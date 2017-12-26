package com.hugovs.zombiekill.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.hugovs.zombiekill.GameScreen;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 21:53<br/>
 */
public class Killer extends Actor {

    private GameScreen screen;

    public Killer(float x, float y, GameScreen screen) {
        super(Textures.getInstance().CHARACTER, x, y);
        this.screen = screen;
    }

    @Override
    public void update(float delta) {
        setY(Gdx.graphics.getHeight() - Gdx.input.getY());
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            screen.actorHolder.addActor(new Bullet(getX(), getY(), screen));
        }
    }

}
