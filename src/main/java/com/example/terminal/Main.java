package com.example.terminal;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class Main extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(450);
        settings.setTitle("Terminal Coita");
        settings.setVersion("0.1");
    }

    @Override
    protected void initGame(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-scene.fxml"));
            AnchorPane root = loader.load();
            FXGL.getGameScene().addUINode(root);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        getGameScene().setBackgroundRepeat("BG.jpg");
    }
}