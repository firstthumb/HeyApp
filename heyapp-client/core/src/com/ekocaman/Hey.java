package com.ekocaman;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Hey extends Game {
    public static final String TITLE = "Hey Project";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        setScreen(new SplashScreen());
    }
}
