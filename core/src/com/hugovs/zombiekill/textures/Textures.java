package com.hugovs.zombiekill.textures;

import com.badlogic.gdx.graphics.Texture;
import com.sun.org.apache.xml.internal.security.signature.ReferenceNotInitializedException;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 22:18<br/>
 */
public class Textures {

    private static Textures instance;

    public final Texture CHARACTER;
    public final Texture ZOMBIE;
    public final Texture BULLET;

    private Textures() {
        CHARACTER = new Texture("character.png");
        ZOMBIE = new Texture("zombie.png");
        BULLET = new Texture("bullet.png");
    }

    public static Textures loadTextures() {
        if (instance == null) instance = new Textures();
        return instance;
    }

    public static Textures getInstance() {
        if (instance == null)
            throw new RuntimeException("Textures are not loaded.");
        return instance;
    }

    public static void dispose() {
        if (instance == null)
            throw new RuntimeException("Textures are not loaded.");
        instance.CHARACTER.dispose();
        instance.ZOMBIE.dispose();
        instance.BULLET.dispose();
    }

}
