package com.hugovs.zombiekill.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.hugovs.zombiekill.actors.bullet.Bullet;
import com.hugovs.zombiekill.actors.bullet.SimpleBullet;
import com.hugovs.zombiekill.textures.Textures;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 21:53<br/>
 */
public class Killer extends Actor {

    private TextureRegion textureRegion;

    public Killer() {
        textureRegion = new TextureRegion(Textures.getInstance().CHARACTER);
        setBounds(textureRegion.getRegionX(), textureRegion.getRegionY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setScale(.7f);
    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        stage.addListener(new InputListener() {
            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                addAction(moveTo(getX(), y));
                return true;
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (Gdx.input.justTouched()) {
                    Bullet bullet = shot();
                    bullet.addAction(Actions.moveBy(getStage().getWidth(), 0, 1f / bullet.getSpeed()));
                    getStage().addActor(bullet);
                }
                return true;
            }
        });

    }

    private Bullet shot() {
        Bullet bullet = new SimpleBullet();
        bullet.setPosition(getX() + 120,getY() + getHeight() * 0.3f - (bullet.getHeight() * bullet.getScaleY()) / 2);
        return bullet;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                getScaleX(), getScaleY(), getRotation());
    }

}
