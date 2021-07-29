package cl.uchile.dcc.scrabble.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("Scrabble Operations");
    var root = new BorderPane();
    root.setLeft(LeftBox.getLeftBox());
    root.setCenter(RightBox.getRightBox());

    Scene scene = new Scene(root, 1024, 800);
    primaryStage.setScene(scene);

    primaryStage.show();


  }


}