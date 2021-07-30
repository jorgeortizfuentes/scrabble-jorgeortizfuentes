package cl.uchile.dcc.scrabble.view;

import java.util.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Class that implements the notifications and allows to get the notification box.
 *
 * @author Jorge Luis Ortiz Fuentes
 */
public class Notifications {

  /**
   * Stack with messages
   */
  private static final Stack<String> messagesStack = new Stack<>();

  /**
   * Label with on-screen notification
   */
  private static final Label messageLabel = DesignFactory.getNotificationLabel();


  /**
   * Get a horizontal box with notifications
   *
   * @return notification box
   */
  public static HBox getNotificationBox() {
    var notificationBox = new HBox(10);// 10 pixels separation
    notificationBox.setPadding(new Insets(15)); // 15 pixels border
    notificationBox.setAlignment(Pos.TOP_CENTER);
    notificationBox.getChildren().add(getMessageLabel());
    return notificationBox;
  }

  /**
   * Get the message label
   *
   * @return message label
   */
  public static Label getMessageLabel() {
    return messageLabel;
  }

  /**
   * Adds a message in string format to the notification stack
   *
   * @param s String with a notification
   */
  public static void addMessage(String s) {
    messagesStack.add(s);
  }

  /**
   * Displays an stack element on the screen or to show the default message
   */
  public static void showLastMessage() {
    if (!messagesStack.isEmpty()) {
      String last = messagesStack.pop();
      messageLabel.setText(last);
    } else if (Operations.isNull()) {
      addMessage("Select an operation");
      showLastMessage();
    } else if (Operations.isComplete()) {
      cleanMessage();
    }
  }

  /**
   * Get the current message in String format
   *
   * @return current message
   */
  public static String getCurrentMessage() {
    return messageLabel.getText();
  }

  /**
   * Clears the message stack and show the default message.
   */
  public static void cleanMessage() {
    messagesStack.clear();
    messagesStack.add("Select an operation");
    showLastMessage();
  }

}
