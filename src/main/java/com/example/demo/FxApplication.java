package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FxApplication extends Application {
    private ConfigurableApplicationContext applicationCtx;

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
        applicationCtx = builder.run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello form JavaFX Spring Boot!");
        Scene scene = new Scene(label, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX with Spring Boot");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        applicationCtx.close();
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
