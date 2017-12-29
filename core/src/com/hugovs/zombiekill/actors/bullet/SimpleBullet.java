package com.hugovs.zombiekill.actors.bullet;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 28/12/2017<br/>
 * Time: 23:48<br/>
 */
public class SimpleBullet extends Bullet {

    private TextureRegion textureRegion;

    public SimpleBullet() {
        super(17, 1);
        textureRegion = new TextureRegion(Textures.getInstance().SIMPLE_BULLET);
        setBounds(textureRegion.getRegionX(), textureRegion.getRegionY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setScale(0.1f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                getScaleX(), getScaleY(), getRotation());
    }

}
