package com.hugovs.zombiekill.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 21:42<br/>
 */
public abstract class Actor {

    protected Sprite sprite;
    protected Rectangle rectangle;

    public Actor(Texture texture, float x, float y) {
        this.sprite = new Sprite(texture);
        sprite.setX(x);
        sprite.setY(y);
        rectangle = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public float getX() {
        return rectangle.getX();
    }

    public void setX(float x) {
        sprite.setX(x);
        rectangle.setX(x);
    }

    public float getY() {
        return rectangle.getY();
    }

    public void setY(float y) {
        sprite.setY(y);
        rectangle.setY(y);
    }

    public float getWidth() {
        return rectangle.getWidth();
    }

    public float getHeight() {
        return rectangle.getHeight();
    }

    public void setScale(float scale) {
        sprite.setScale(scale);
        rectangle.height = rectangle.height * scale;
        rectangle.width = rectangle.width * scale;
    }

    public void draw(Batch batch) {
        batch.draw(sprite, rectangle.x , rectangle.y, rectangle.width, rectangle.height);
    }

    public void update(float delta) {}

    public boolean overlaps(Actor actor) {
        return rectangle.overlaps(actor.rectangle);
    }

    public static class Holder {

        private Array<Actor> actors;

        public Holder() {
            actors = new Array<Actor>();
        }

        public void addActor(Actor actor) {
            actors.add(actor);
        }

        public void update(float delta) {
            for (Actor actor : actors)
                actor.update(delta);
        }

        public void draw(SpriteBatch batch) {
            for (Actor actor : actors)
                actor.draw(batch);
        }

        public Array<Actor> getActors() {
            return actors;
        }

    }

}
