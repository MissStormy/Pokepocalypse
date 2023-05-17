module com.pokejavafx.pokejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires java.sql;

    opens com.pokejavafx.pokejavafx to javafx.fxml;
    exports com.pokejavafx.pokejavafx;
}