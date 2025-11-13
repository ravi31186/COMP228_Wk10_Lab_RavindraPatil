package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        FormUI form = new FormUI();
        Scene scene = new Scene(form.getFormLayout(), 650, 700);

        primaryStage.setScene(scene);
        primaryStage.setTitle("wk10_lab_RavindraPatil");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
