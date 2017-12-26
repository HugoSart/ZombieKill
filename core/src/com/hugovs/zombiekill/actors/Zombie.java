package com.hugovs.zombiekill.actors;

import com.badlogic.gdx.graphics.Texture;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 22:18<br/>
 */
public class Zombie extends Actor {

    public Zombie(float x, float y) {
        super(Textures.getInstance().ZOMBIE, x, y);
        sprite.flip(true, false);
        sprite.setScale(0.7f);
        rectangle.height = rectangle.height * 0.7f;
        rectangle.width = rectangle.width * 0.7f;
    }

    @Override
    public void update(float delta) {
        setX(getX() - 1);
    }

}
