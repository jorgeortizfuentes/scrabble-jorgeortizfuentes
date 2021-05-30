package cl.uchile.dcc.scrabble.gui;

public interface ScrabbleType {
    String toString();
    boolean equals(Object obj);
    int hashCode();
    ScrabbleString asString();

    // add method
    // c a la derecha
    ScrabbleType addWith(ScrabbleType c);
    //c es el this y está a la izquierda
    ScrabbleType addedByString(ScrabbleString c);
    ScrabbleType addedByInt(ScrabbleInt c);
    ScrabbleType addedByFloat(ScrabbleFloat c);
    ScrabbleType addedByBinary(ScrabbleBinary c);
    ScrabbleType addedByBool(ScrabbleBoolean c);


    //ScrabbleType conjunction(ScrabbleType c);
    //ScrabbleType conjunctionBy(ScrabbleType c);
    //ScrabbleType disjunction(ScrabbleType c);
    //ScrabbleType disjunctionBy(ScrabbleType c);
    //ScrabbleType subtract(ScrabbleType c);
    //ScrabbleType subtractBy(ScrabbleType c);
    //ScrabbleType multiply(ScrabbleType c);
    //ScrabbleType multiplyBy(ScrabbleType c);
    //ScrabbleType divide(ScrabbleType c);
    //ScrabbleType divideBy(ScrabbleType c);
    //ScrabbleType negation(ScrabbleType c);


}
