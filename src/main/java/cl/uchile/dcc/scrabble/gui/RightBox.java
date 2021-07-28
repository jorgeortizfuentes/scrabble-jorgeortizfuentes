package cl.uchile.dcc.scrabble.gui;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class RightBox {

  public static VBox getRightBox() {
    var centerBox = new VBox(10);// 10 pixels separation
    centerBox.setPadding(new Insets(15)); // 15 pixels border

    centerBox.getChildren().add(Notifications.getNotificationBox());
    centerBox.getChildren().add(Operations.getOperationBox());
    centerBox.getChildren().add(Result.getResultBox());
    centerBox.getChildren().add(Values.getValuesBox());

    return centerBox;
  }


}
