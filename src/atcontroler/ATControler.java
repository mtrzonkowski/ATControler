/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atcontroler;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author mtrzonkowski
 */
public class ATControler extends Application {

  
   
    @Override
    public void start(Stage primaryStage) {
        
        Image img = new Image("atcontroler/airplane.png");
        ImageView iv = new ImageView(img);
        iv.setScaleX(0.1);
        iv.setScaleY(0.1);
  
        
        RadialGradient g = new RadialGradient(
                0, 0,
                0.35, 0.35,
                0.5,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.WHITE),
                new Stop(1.0, Color.RED));
        Circle ball = new Circle(0, 0, 20);
        ball.setFill(new ImagePattern(img, 0, 0, 1, 1, true));
        
        
        
        
        Group root = new Group();
        root.getChildren().add(ball);
        root.getChildren().add(iv);
        
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.show();
        
        TranslateTransition t = new TranslateTransition(
                Duration.millis(1000), ball);
        
        t.setFromX(ball.getRadius());
        t.setToX(scene.getWidth() - ball.getRadius());
        t.setFromY(scene.getHeight()/2);
        t.setToY(scene.getHeight()/2);
        t.setCycleCount(Transition.INDEFINITE);
        t.setAutoReverse(true);
        t.setInterpolator(Interpolator.LINEAR);
        t.play();
    
       
        
    }

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
        launch(args);
    }
    
}
