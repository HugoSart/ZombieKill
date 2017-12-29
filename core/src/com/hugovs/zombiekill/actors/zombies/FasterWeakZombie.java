package com.hugovs.zombiekill.actors.zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hugovs.zombiekill.utils.Utils;

/**
 * User: hugo_<br/>
 * Date: 29/12/2017<br/>
 * Time: 00:27<br/>
 */
public class FasterWeakZombie extends Zombie {

    private Animation<TextureRegion> walkAnimation;
    private float stateTime;

    public FasterWeakZombie() {
        super(17f, 2f);
        stateTime = 0f;
        walkAnimation = Utils.createZombieWalkAnimation(0, 7);
        TextureRegion tex = walkAnimation.getKeyFrames()[0];
        setBounds(0, 0, tex.getRegionWidth(), tex.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                getScaleX(), getScaleY(), getRotation());
    }

}
