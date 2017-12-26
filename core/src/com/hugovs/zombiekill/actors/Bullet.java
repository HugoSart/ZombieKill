package com.hugovs.zombiekill.actors;

import com.hugovs.zombiekill.GameScreen;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 22:45<br/>
 */
public class Bullet extends Actor {

    private GameScreen screen;

    public Bullet(float x, float y, GameScreen screen) {
        super(Textures.getInstance().BULLET, x, y);
        sprite.setScale(0.2f);
        rectangle.height = rectangle.height * 0.2f;
        rectangle.width = rectangle.width * 0.2f;
        this.screen = screen;
    }

    @Override
    public void update(float delta) {
        setX(getX() + 4);
        for (int i = 0; i < screen.actorHolder.getActors().size; i++) {
            Actor actor = screen.actorHolder.getActors().get(i);
            if (actor instanceof Zombie && overlaps(actor)) {
                screen.actorHolder.getActors().removeValue(this, true);
                screen.actorHolder.getActors().removeValue(actor, true);
            }
        }
    }

}
