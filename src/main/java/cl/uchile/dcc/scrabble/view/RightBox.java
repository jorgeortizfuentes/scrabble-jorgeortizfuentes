package cl.uchile.dcc.scrabble.view;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class RightBox {

  public static VBox getRightBox() {
    var centerBox = new VBox(10);// 10 pixels separation
    //centerBox.setPadding(new Insets(15)); // 15 pixels border
    centerBox.setPadding(new Insets(30, 30, 0, 0)); // 15 pixels border

    centerBox.getChildren().add(Notifications.getNotificationBox());
    centerBox.getChildren().add(Result.getResultBox());
    centerBox.getChildren().add(Operations.getOperationsBoxScroll());
    VBox.setMargin(Operations.getOperationsBoxScroll(), new Insets(5, 120, 5, 120));

    //centerBox.getChildren().add(Operations.getOperationBox());
    //centerBox.setMargin(Operations.getOperationBox(), new Insets(5,120,5,120));
    centerBox.getChildren().add(Calculate.getCalculateBox());
    centerBox.getChildren().add(InsertValues.getValuesBox());

    return centerBox;
  }


}
