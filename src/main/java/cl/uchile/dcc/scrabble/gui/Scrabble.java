package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Jorge Luis Ortiz Fuentes
 */
public class Scrabble extends Application {

  private static VBox leftVerticalBox;


  private static ChoiceBox valueTypeBox;
  private static TextField valueText;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {


    primaryStage.setTitle("Scrabble Operations");
    // Root
    var root = new BorderPane();




    // Root
    root.setLeft(LeftBox.getLeftBox());
    root.setCenter(RightBox.getRightBox());



    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 1024, 800);
    primaryStage.setScene(scene);

    primaryStage.show();


  }



}