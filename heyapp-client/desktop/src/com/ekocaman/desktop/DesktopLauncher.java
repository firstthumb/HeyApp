package com.ekocaman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ekocaman.Hey;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = Hey.HEIGHT;
        config.width = Hey.WIDTH;


        new LwjglApplication(new Hey(), config);
    }
}
