package com.hugovs.zombiekill.actors.zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * User: hugo_<br/>
 * Date: 27/12/2017<br/>
 * Time: 00:42<br/>
 */
public class WeakZombie extends Zombie {

    private static final int TEXTURE_REGION_INDEX_X = 0;
    private static final int TEXTURE_REGION_INDEX_Y = 3;

    private Animation<TextureRegion> walkAnimation;
    private float stateTime;

    public WeakZombie(float x, float y) {
        super(x, y);
        defineWalkAnimation();
        stateTime = 0f;
        rectangle.setWidth(regions[0][0].getRegionWidth());
        rectangle.setHeight(regions[0][0].getRegionHeight());
        health = 17f;
    }

    @Override
    public void draw(Batch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, rectangle.getX(), rectangle.getY());
    }

    private void defineWalkAnimation() {
        TextureRegion[] walkFrames = new TextureRegion[3];
        walkFrames[0] = Zombie.regions[TEXTURE_REGION_INDEX_Y][TEXTURE_REGION_INDEX_X];
        walkFrames[1] = Zombie.regions[TEXTURE_REGION_INDEX_Y][TEXTURE_REGION_INDEX_X + 1];
        walkFrames[2] = Zombie.regions[TEXTURE_REGION_INDEX_Y][TEXTURE_REGION_INDEX_X + 2];
        walkAnimation = new Animation<TextureRegion>(0.25f, walkFrames);
    }

}
