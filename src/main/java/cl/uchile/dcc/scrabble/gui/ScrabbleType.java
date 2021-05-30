package cl.uchile.dcc.scrabble.gui;

public interface ScrabbleType {
    String toString();
    boolean equals(Object obj);
    int hashCode();
    ScrabbleString asString();
    ScrabbleType addWith(ScrabbleType c);
    ScrabbleType addedByString(ScrabbleString c);
    ScrabbleType addedByInt(ScrabbleInt c);
    ScrabbleType addedByFloat(ScrabbleFloat c);
    ScrabbleType addedByBinary(ScrabbleBinary c);
    ScrabbleType addedByBool(ScrabbleBoolean c);


}
