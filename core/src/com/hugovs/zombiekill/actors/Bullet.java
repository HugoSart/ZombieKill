package com.hugovs.zombiekill.actors;

import com.badlogic.gdx.Gdx;
import com.hugovs.zombiekill.actors.zombies.Zombie;
import com.hugovs.zombiekill.screens.GameScreen;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 22:45<br/>
 */
public class Bullet extends Actor {

    private GameScreen screen;
    private float damage = 17f;

    public Bullet(float x, float y, GameScreen screen) {
        super(Textures.getInstance().BULLET, x + 120, y + 30);
        this.screen = screen;
        setScale(0.1f);
    }

    @Override
    public void update(float delta) {
        setX(getX() + 4);
        for (int i = 0; i < screen.actorHolder.getActors().size; i++) {
            Actor actor = screen.actorHolder.getActors().get(i);
            if (actor instanceof Zombie && overlaps(actor)) {
                screen.actorHolder.getActors().removeValue(this, true);
                if (((Zombie) actor).hit(damage))
                    screen.actorHolder.getActors().removeValue(actor, true);
            } else if (getX() > Gdx.graphics.getWidth()) {
                screen.actorHolder.getActors().removeValue(this, true);
            }
        }
    }

}
