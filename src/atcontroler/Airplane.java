/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atcontroler;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
/**
 *
 * @author mtrzonkowski
 */
public class Airplane extends Group{
    final Rotate rx = new Rotate(0,Rotate.X_AXIS);
    
    public Airplane(double size, Color color){
        getTransforms().addAll(rx);
        getChildren().addAll(
    RectangleBuilder.create() // back face
        .width(size).height(size)
        .fill(color.deriveColor(1, 1.0, 1, 1.0))
        .build());
    }
}
