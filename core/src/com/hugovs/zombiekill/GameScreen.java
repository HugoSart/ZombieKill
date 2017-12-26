package com.hugovs.zombiekill;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.hugovs.zombiekill.actors.Actor;
import com.hugovs.zombiekill.actors.Killer;
import com.hugovs.zombiekill.actors.Zombie;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 21:31<br/>
 */
public class GameScreen extends ScreenAdapter {

    private ZombieKill game;

    private OrthographicCamera camera;

    public Actor.Holder actorHolder;
    private Killer killer;

    private long lastDropTime;

    public GameScreen(ZombieKill game) {
        this.game = game;

        Textures.loadTextures();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        killer = new Killer(0,0, this);

        actorHolder = new Actor.Holder();
        actorHolder.addActor(killer);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            actorHolder.addActor(new Zombie(Gdx.graphics.getWidth(), MathUtils.random(Gdx.graphics.getHeight())));
            lastDropTime = TimeUtils.nanoTime();
        }

        camera.update();
        actorHolder.update(delta);

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        actorHolder.draw(game.batch);

        game.batch.end();

    }

    @Override
    public void dispose() {
        Textures.dispose();
    }
}
