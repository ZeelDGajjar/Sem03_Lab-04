/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sem3_lab04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 2474008
 */
public class Sem3_Lab04 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("Business App"); 
        Label label = new Label("Press a key"); 
        
        GridPane root = new GridPane();
        
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene); 
        stage.show(); 
    }
}
