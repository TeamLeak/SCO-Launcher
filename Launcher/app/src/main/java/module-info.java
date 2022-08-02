module app {

    requires core;
    requires javafx.controls;
    requires transitive appUI;

    opens com.github.lkapitman.starter to javafx.graphics;
}
