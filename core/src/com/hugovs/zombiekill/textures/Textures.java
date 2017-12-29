package com.hugovs.zombiekill.textures;

import com.badlogic.gdx.graphics.Texture;

/**
 * User: hugo_<br/>
 * Date: 25/12/2017<br/>
 * Time: 22:18<br/>
 */
public class Textures {

    private static Textures instance;

    public final Texture CHARACTER;
    public final Texture ZOMBIE;
    public final Texture SIMPLE_BULLET;
    public final Texture BULLET_BILL;
    public final Texture ZOMBIES_SHEET;
    public final Texture VALLE;

    private Textures() {
        CHARACTER = new Texture("character.png");
        ZOMBIE = new Texture("zombie.png");
        SIMPLE_BULLET = new Texture("simple_bullet.png");
        BULLET_BILL = new Texture("bullet_bill.png");
        ZOMBIES_SHEET = new Texture("zombies_sheet.png");
        VALLE = new Texture("valle.png");
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
        instance.SIMPLE_BULLET.dispose();
        instance.BULLET_BILL.dispose();
        instance.ZOMBIES_SHEET.dispose();
        instance.VALLE.dispose();
    }

}
