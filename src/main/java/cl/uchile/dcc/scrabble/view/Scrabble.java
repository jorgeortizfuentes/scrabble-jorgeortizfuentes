package cl.uchile.dcc.scrabble.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Main entry point for the Scrabble Application.
 * <p>
 * Through a layout divided into two parts (left and right), the program allows you to insert
 * operations, transformations and values to be calculated at the push of a button.
 *
 * @author Jorge Luis Ortiz Fuentes
 */
public class Scrabble extends Application {


  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Build the layout and insert the left and right part. Then visualize it.
   *
   * @param primaryStage default primary Stage
   */
  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("Scrabble Operations");
    var root = new BorderPane();
    root.setLeft(LeftBox.getLeftBox());
    root.setCenter(RightBox.getRightBox());

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);

    primaryStage.show();


  }


}