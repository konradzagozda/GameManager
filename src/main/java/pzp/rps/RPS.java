package pzp.rps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;


public class RPS extends Application {

    Lablepane lablepane=new Lablepane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);

        Label label = new Label("Start the game:");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
        pane.add(label, 0, 0);
        //paper
        Image image1 = new Image("images/paper.png");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(150);
        imageView1.setFitWidth(150);
        pane.add(imageView1, 0, 1);
        Image1HanderClass image1HanderClass = new Image1HanderClass();
        Button btOK1 = new Button("paper");
        pane.add(btOK1, 0, 2);
        btOK1.setOnAction(image1HanderClass);
        //stone
        Image image2 = new Image("images/rock.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(150);
        imageView2.setFitWidth(150);
        pane.add(imageView2, 1, 1);
        Image2HanderClass image2HanderClass = new Image2HanderClass();
        Button btOK2 = new Button("stone");
        pane.add(btOK2, 1, 2);
        btOK2.setOnAction(image2HanderClass);
        //scissors
        Image image3 = new Image("images/scissors.png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(150);
        imageView3.setFitWidth(150);
        pane.add(imageView3, 2, 1);
        Image3HanderClass image3HanderClass = new Image3HanderClass();
        Button btOK3 = new Button("scissors");
        pane.add(btOK3, 2, 2);
        btOK3.setOnAction(image3HanderClass);


        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lablepane);
        BorderPane.setAlignment(pane,Pos.CENTER);


        pane.setStyle("-fx-background-color: #0effb8");

        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setTitle("rock-paper-scissors");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    class Image1HanderClass implements EventHandler<ActionEvent> {

        //Cloth 2
        @Override
        public void handle(ActionEvent event) {
            Game game = new Game();
            String str = game.playgame(2);
            //setStr1(str);
            lablepane.show(str);
            System.out.println(str);

        }
    }

    class Image2HanderClass implements EventHandler<ActionEvent> {

        //Stone 0
        @Override
        public void handle(ActionEvent event) {
            Game game = new Game();
            String str = game.playgame(0);
            //setStr1(str);
            lablepane.show(str);
            System.out.println(str);
        }
    }

    class Image3HanderClass implements EventHandler<ActionEvent> {

        //Scissors 1
        @Override
        public void handle(ActionEvent event) {
            Game game = new Game();
            String str = game.playgame(1);
            //setStr1(str);
            lablepane.show(str);
            System.out.println(str);
        }
    }
    class Lablepane extends StackPane{
        private Label label=new Label("result");
        public Lablepane(){
            getChildren().add(label);
            label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
        }
        public void show(String str){
            label.setText(str);
        }
    }

}