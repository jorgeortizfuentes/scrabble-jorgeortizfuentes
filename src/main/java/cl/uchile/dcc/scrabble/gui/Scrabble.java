package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    primaryStage.setTitle("Final reality");

    Label label = new Label("This will be an app sometime");
    label.setAlignment(Pos.CENTER);

    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(label, 400, 200);
    primaryStage.setScene(scene);


    primaryStage.show();


    //System.out.println(Integer.toBinaryString(-22));
    //System.out.println(BinUtilities.intToBinary(-33));

    var a = new ScrabbleString("Pandi");
    var a2 = new ScrabbleString("Linda Hermosa");
    var b = new ScrabbleBinary("101110");
    var b2 = new ScrabbleBinary("111111");
    var c = new ScrabbleBoolean(true);
    var c2 = new ScrabbleBoolean(false);

    var d = new ScrabbleFloat(1.5);
    var e = new ScrabbleInt(13);
    //System.out.println(a.add(b));
    //System.out.println(a.add(c));
    //System.out.println(a.add(d));
    //System.out.println(a.add(e));
    System.out.println(c.conjunctionWith(b));
    System.out.println(c.conjunctionWith(b2));
    System.out.println(c.conjunctionWith(c2));
    System.out.println(c.conjunctionWith(c));
    System.out.println(b.conjunctionWith(c));
    System.out.println(b2.conjunctionWith(c));
    //System.out.println(b.negation());
    //System.out.println(c.negation());

    System.out.println(a.addWith(d));

  }
}