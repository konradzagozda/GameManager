package pzp;

import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Settings settings = new Settings();
        settings.setLang(new Locale("en"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/managerView.fxml"));   
        loader.setResources(settings.getBundle());
        Parent root = loader.load();
        
        ManagerViewController controller = loader.getController();
        controller.changeSettings(settings);
        
        primaryStage.setTitle("GameManager");
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(settings.getThemePath());
        scene.getStylesheets().add(settings.getFontPath());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
