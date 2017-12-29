package com.hugovs.zombiekill.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hugovs.zombiekill.GameSettings;
import com.hugovs.zombiekill.actors.Killer;
import com.hugovs.zombiekill.actors.zombies.FasterWeakZombie;
import com.hugovs.zombiekill.actors.zombies.WeakZombie;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 21:31<br/>
 */
public class GameScreen extends ScreenAdapter {

    // Stage and Actors
    private final Stage stage;

    public GameScreen() {
        Textures.loadTextures();
        stage = new Stage(new FitViewport(GameSettings.WIDTH, GameSettings.HEIGHT, new OrthographicCamera(GameSettings.WIDTH, GameSettings.HEIGHT)));
        Gdx.input.setInputProcessor(stage);

        // Setup Sate and Actors
        Killer killer = new Killer();
        stage.addActor(killer);
        stage.addActor(new FasterWeakZombie());

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        Textures.dispose();
        stage.dispose();
    }

    public void update(float delta) {
        stage.getCamera().update();
        stage.act(delta);
    }

}
