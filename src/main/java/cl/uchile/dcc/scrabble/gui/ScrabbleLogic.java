package cl.uchile.dcc.scrabble.gui;

public interface ScrabbleLogic {
    ScrabbleLogic negation();
    ScrabbleLogic conjunctionWith(ScrabbleLogic c);
    ScrabbleLogic conjunctionByBoolean(ScrabbleBoolean c);
    ScrabbleLogic conjunctionByBinary(ScrabbleBinary c);
    ScrabbleLogic disjunctionWith(ScrabbleLogic c);
    ScrabbleLogic disjunctionByBoolean(ScrabbleBoolean c);
    ScrabbleLogic disjunctionByBinary(ScrabbleBinary c);
}
