package com.hugovs.zombiekill.actors.zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hugovs.zombiekill.ZombieKill;

import static com.hugovs.zombiekill.actors.zombies.Zombie.regions;

/**
 * User: hugo_<br/>
 * Date: 27/12/2017<br/>
 * Time: 01:30<br/>
 */
public class StrongZombie extends Zombie {

    private static final int TEXTURE_REGION_INDEX_X = 6;
    private static final int TEXTURE_REGION_INDEX_Y = 3;

    private Animation<TextureRegion> walkAnimation;
    private float stateTime;

    public StrongZombie(float x, float y) {
        super(x, y);
        defineWalkAnimation();
        stateTime = 0f;
        rectangle.setWidth(regions[0][0].getRegionWidth());
        rectangle.setHeight(regions[0][0].getRegionHeight());
        health = 60f;
    }

    @Override
    public void draw(Batch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, rectangle.getX(), rectangle.getY());
    }

    private void defineWalkAnimation() {
        TextureRegion[] walkFrames = new TextureRegion[3];
        walkFrames[0] = regions[TEXTURE_REGION_INDEX_Y][TEXTURE_REGION_INDEX_X];
        walkFrames[1] = regions[TEXTURE_REGION_INDEX_Y][TEXTURE_REGION_INDEX_X + 1];
        walkFrames[2] = regions[TEXTURE_REGION_INDEX_Y][TEXTURE_REGION_INDEX_X + 2];
        walkAnimation = new Animation<TextureRegion>(0.25f, walkFrames);
    }

}
