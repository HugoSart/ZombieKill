package com.hugovs.zombiekill.actors.zombies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 29/12/2017<br/>
 * Time: 00:25<br/>
 */
public abstract class Zombie extends Actor {

    private float maxHealth;
    private float currentHealth;

    private float speed;

    public static TextureRegion[][] regions;

    public Zombie(float maxHealth, float speed) {
        this.maxHealth = maxHealth;
        Texture texture = Textures.getInstance().ZOMBIES_SHEET;
        if (regions == null) regions = TextureRegion.split(texture, texture.getWidth() / 12, texture.getHeight() / 8);
    }

    public float getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(float currentHealth) {
        this.currentHealth = currentHealth;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean takeDamage(float damage) {
        maxHealth = maxHealth - damage < 0 ? 0 : maxHealth - damage;
        return maxHealth - damage <= 0;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
