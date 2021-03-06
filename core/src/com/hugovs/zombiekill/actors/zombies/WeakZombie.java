package com.hugovs.zombiekill.actors.zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hugovs.zombiekill.textures.Textures;
import com.hugovs.zombiekill.utils.Utils;

/**
 * User: hugo_<br/>
 * Date: 29/12/2017<br/>
 * Time: 00:27<br/>
 */
public class WeakZombie extends Zombie {

    private Animation<TextureRegion> walkAnimation;
    private float stateTime;

    public WeakZombie() {
        super(24f, 1f);
        stateTime = 0f;
        walkAnimation = Utils.createZombieWalkAnimation(0, 3);
        TextureRegion tex = walkAnimation.getKeyFrames()[0];
        setBounds(tex.getRegionX(),tex.getRegionY(),tex.getRegionWidth(),tex.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                getScaleX(), getScaleY(), getRotation());
    }

}
