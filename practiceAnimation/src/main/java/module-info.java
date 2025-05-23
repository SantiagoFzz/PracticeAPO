module org.icesi.practiceanimation {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.practiceanimation to javafx.fxml;
    exports org.icesi.practiceanimation;
}