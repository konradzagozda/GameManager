package pzp;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pzp.rps.RPS;
import pzp.tictactoe.TicTacToe;

public class ManagerViewController implements Initializable {
    private Settings settings;
    
    @FXML
    private GridPane mainPane;
    
    public ManagerViewController() {
        
    }
    
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settings = new Settings();
        settings.setLang(new Locale("en"));
    }
    
    @FXML
    public void handleSettingsButton(ActionEvent event) throws Exception {        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/settingsView.fxml"));   
        loader.setResources(settings.getBundle());
        Parent root = loader.load();
        
        SettingsViewController controller = loader.getController();
        controller.changeSettings(settings);
        controller.initValues();
        
        Stage stage = (Stage) mainPane.getScene().getWindow();
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(settings.getThemePath());
        scene.getStylesheets().add(settings.getFontPath());
        stage.setScene(scene);
        stage.show();
    }
    
    public void changeSettings(Settings settings) {
        this.settings = settings;
    }

    public void runTicTacToe(ActionEvent actionEvent) throws Exception {
        var ttt = new TicTacToe();
        ttt.start(new Stage());
    }

    public void runRPS(ActionEvent actionEvent) throws Exception {
        var rps = new RPS();
        rps.start(new Stage());
    }
}
