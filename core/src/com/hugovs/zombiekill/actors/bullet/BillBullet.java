package com.hugovs.zombiekill.actors.bullet;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hugovs.zombiekill.textures.Textures;

/**
 * User: hugo_<br/>
 * Date: 29/12/2017<br/>
 * Time: 00:12<br/>
 */
public class BillBullet extends Bullet {

    private TextureRegion textureRegion;

    public BillBullet() {
        super(60, 0.7f);
        textureRegion = new TextureRegion(Textures.getInstance().BULLET_BILL);
        textureRegion.flip(true,false);
        setBounds(textureRegion.getRegionX(), textureRegion.getRegionY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setScale(0.2f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                getScaleX(), getScaleY(), getRotation());
    }

}
