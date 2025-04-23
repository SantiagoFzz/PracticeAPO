module org.icesi.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.demo to javafx.fxml;
    exports org.icesi.demo;
}