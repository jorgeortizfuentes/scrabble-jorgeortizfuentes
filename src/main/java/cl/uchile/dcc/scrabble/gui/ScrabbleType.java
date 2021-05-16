package cl.uchile.dcc.scrabble.gui;

public interface ScrabbleType {
    String toString();
    ScrabbleString asString();
    boolean equals(Object obj);
    ScrabbleType add(ScrabbleType c);
    ScrabbleType addedBy(ScrabbleType c);
    ScrabbleType conjunction(ScrabbleType c);
    ScrabbleType conjunctionBy(ScrabbleType c);
    ScrabbleType disjunction(ScrabbleType c);
    ScrabbleType disjunctionBy(ScrabbleType c);
    ScrabbleType subtract(ScrabbleType c);
    ScrabbleType subtractBy(ScrabbleType c);
    ScrabbleType multiply(ScrabbleType c);
    ScrabbleType multiplyBy(ScrabbleType c);
    ScrabbleType divide(ScrabbleType c);
    ScrabbleType divideBy(ScrabbleType c);
    ScrabbleType negation(ScrabbleType c);
    //int addTo();
    //int addBy();


}
