module org.icesi.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.demo to javafx.fxml;
    exports org.icesi.demo;
    exports org.icesi.demo.control;
    opens org.icesi.demo.control to javafx.fxml;
}