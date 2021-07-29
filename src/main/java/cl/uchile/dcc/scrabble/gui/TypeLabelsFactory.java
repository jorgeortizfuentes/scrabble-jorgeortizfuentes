package cl.uchile.dcc.scrabble.gui;

import javafx.scene.control.Label;

public class TypeLabelsFactory extends FormFactory{

  public static Label getStringLabel(){
    var opType = FormFactory.getTypeObjectLabel("DARKRED");
    opType.setText("STR");
    return opType;
  }

  public static Label getIntLabel(){
    var opType = FormFactory.getTypeObjectLabel("DARKBLUE");
    opType.setText("INT");
    return opType;
  }

  public static Label getFloatLabel(){
    var opType = FormFactory.getTypeObjectLabel("MEDIUMVIOLETRED");
    opType.setText("FLOAT");
    return opType;
  }

  public static Label getBinaryLabel(){
    var opType = FormFactory.getTypeObjectLabel("DARKSLATEGRAY");
    opType.setText("BIN");
    return opType;
  }

  public static Label getBooleanLabel(){
    var opType = FormFactory.getTypeObjectLabel("MAROON");
    opType.setText("BOOL");
    return opType;
  }
}
