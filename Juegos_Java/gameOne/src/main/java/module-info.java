module org.example.gameone {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.gameone to javafx.fxml;
    exports org.example.gameone;
    exports org.example.gameone.implementation;
    opens org.example.gameone.implementation to javafx.fxml;
    exports org.example.gameone.entities;
    opens org.example.gameone.entities to javafx.fxml;
}