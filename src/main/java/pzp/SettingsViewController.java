package pzp;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kochr
 */
public class SettingsViewController implements Initializable {
    private Settings settings;
    
    @FXML
    private GridPane mainPane;
    @FXML
    private ChoiceBox<String> language;
    @FXML
    private ChoiceBox<String> theme;
    @FXML
    private ChoiceBox<String> font;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void confirmChanges(ActionEvent event) throws Exception {
        // changing themes
        String currentTheme = theme.getSelectionModel().getSelectedItem();
        if (currentTheme.equals(settings.getBundle().getString("theme.light"))) {
            settings.setThemeName("theme.light");
        } else if (currentTheme.equals(settings.getBundle().getString("theme.dark"))) {
            settings.setThemeName("theme.dark");
        } else if (currentTheme.equals(settings.getBundle().getString("theme.pink"))) {
            settings.setThemeName("theme.pink");
        }
        
        String currentFont = font.getSelectionModel().getSelectedItem();
        settings.setFontName(currentFont);
        
        // changing language
        String currentLanguage = language.getSelectionModel().getSelectedItem();
        
        if (currentLanguage.equals("English")) {
            settings.setLang(new Locale("en"));
        } else if (currentLanguage.equals("Polski")) {
            settings.setLang(new Locale("pl"));
        }
        
        settings.setLanguageName(currentLanguage); 
        reload();
    }
    
    public void handleReturn(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/managerView.fxml"));   
        loader.setResources(settings.getBundle());
        Parent root = loader.load();
        
        ManagerViewController controller = loader.getController();
        controller.changeSettings(settings);
        
        Stage stage = (Stage) mainPane.getScene().getWindow();
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(settings.getThemePath());
        scene.getStylesheets().add(settings.getFontPath());
        stage.setScene(scene);
        stage.show();
    }
    
    public void reload() throws Exception {
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
    
    public void initValues() {
        // jêzyk
        ArrayList<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Polski");
        
        ObservableList<String> list1 = FXCollections.observableArrayList(languages);
        language.setItems(list1);
        
        // motywy
        ArrayList<String> themes = new ArrayList<>();
        themes.add(settings.getBundle().getString("theme.light"));
        themes.add(settings.getBundle().getString("theme.dark"));
        themes.add(settings.getBundle().getString("theme.pink"));
        
        ObservableList<String> list2 = FXCollections.observableArrayList(themes);
        theme.setItems(list2);
        
        // czcionki
        ArrayList<String> fonts = new ArrayList<>();
        fonts.add("10pt");
        fonts.add("12pt");
        fonts.add("14pt");
        
        ObservableList<String> list3 = FXCollections.observableArrayList(fonts);
        font.setItems(list3);
        
        // wartoœci domyœlne
       language.setValue(settings.getLanguageName());
       theme.setValue(settings.getBundle().getString(settings.getThemeName()));
       font.setValue(settings.getFontName());
    }
    
    public void changeSettings(Settings settings) {
        this.settings = settings;
    }
}
