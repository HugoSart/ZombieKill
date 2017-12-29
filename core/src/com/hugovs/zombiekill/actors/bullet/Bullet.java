package com.hugovs.zombiekill.actors.bullet;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * User: hugo_<br/>
 * Date: 28/12/2017<br/>
 * Time: 23:45<br/>
 */
public abstract class Bullet extends Actor {

    private float damage;
    private float speed;

    public Bullet(float damage, float speed) {
        this.damage = damage;
        this.speed = speed;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getDamage() {
        return damage;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
