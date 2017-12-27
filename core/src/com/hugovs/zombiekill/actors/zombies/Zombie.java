package com.hugovs.zombiekill.actors.zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Pool;
import com.hugovs.zombiekill.actors.Actor;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 22:18<br/>
 */
public abstract class Zombie extends Actor {

    protected static TextureRegion[][] regions;

    protected float speed = 1f;
    protected float health = 17f;

    public Zombie(float x, float y) {
        super(Textures.getInstance().ZOMBIES_SHEET, x, y);
        regions = TextureRegion.split(sprite.getTexture(), (int)sprite.getWidth() / 12, (int)sprite.getHeight() / 8);
    }

    @Override
    public void update(float delta) {
        setX(getX() - speed);
    }

    public boolean hit(float damage) {
        health -= damage;
        return health <= 0;
    }

}
