package cl.uchile.dcc.scrabble.gui;

import javafx.scene.layout.BorderPane;

public class Layout {

  public Layout() {
    var root = new BorderPane();

    // Root
    root.setLeft(Scrabble.leftVerticalBox());
    root.setCenter(Scrabble.centerVerticalBox());

  }
}
