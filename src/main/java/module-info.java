module com.example.airport {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires commons.math3;

    opens assets.textures;
    opens com.example.terminal to javafx.fxml;
    exports com.example.terminal;
    exports com.example.terminal.factory;
    opens com.example.terminal.factory to javafx.fxml;
    exports com.example.terminal.controller;
    opens com.example.terminal.controller to javafx.fxml;
}