package com.hugovs.zombiekill.utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hugovs.zombiekill.actors.zombies.Zombie;

/**
 * User: hugo_<br/>
 * Date: 29/12/2017<br/>
 * Time: 00:36<br/>
 */
public class Utils {

    public static Animation<TextureRegion> createZombieWalkAnimation(int textureRegionIndexX, int textureRegionIndexY) {
        TextureRegion[] walkFrames = new TextureRegion[4];
        walkFrames[0] = Zombie.regions[textureRegionIndexY][textureRegionIndexX];
        walkFrames[1] = Zombie.regions[textureRegionIndexY][textureRegionIndexX + 1];
        walkFrames[2] = Zombie.regions[textureRegionIndexY][textureRegionIndexX + 2];
        walkFrames[3] = Zombie.regions[textureRegionIndexY][textureRegionIndexX + 1];
        return new Animation<>(0.25f, walkFrames);
    }

    public static Pixmap createProceduralPixmap(int width, int height, int r, int g, int b) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(r, g, b, 1);
        pixmap.fill();
        return pixmap;
    }

}
