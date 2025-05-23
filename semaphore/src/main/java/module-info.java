module org.icesi.semaphore {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.semaphore to javafx.fxml;
    exports org.icesi.semaphore;
}