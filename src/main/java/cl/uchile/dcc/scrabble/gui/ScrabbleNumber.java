package cl.uchile.dcc.scrabble.gui;

public interface ScrabbleNumber {

    ScrabbleType addWith(ScrabbleType c);
    ScrabbleType addedByString(ScrabbleString c);
    ScrabbleType addedByInt(ScrabbleInt c);
    ScrabbleType addedByFloat(ScrabbleFloat c);
    ScrabbleType addedByBinary(ScrabbleBinary c);
    ScrabbleType addedByBool(ScrabbleBoolean c);

    ScrabbleType subtractWith(ScrabbleNumber c);
    ScrabbleType subtractedByInt(ScrabbleInt c);
    ScrabbleType subtractedByFloat(ScrabbleFloat c);
    ScrabbleType subtractedByBinary(ScrabbleBinary c);

    ScrabbleType multiplyWith(ScrabbleNumber c);
    ScrabbleType multipliedByInt(ScrabbleInt c);
    ScrabbleType multipliedByFloat(ScrabbleFloat c);
    ScrabbleType multipliedByBinary(ScrabbleBinary c);

    ScrabbleType divideWith(ScrabbleNumber c);
    ScrabbleType dividedByInt(ScrabbleInt c);
    ScrabbleType dividedByFloat(ScrabbleFloat c);
    ScrabbleType dividedByBinary(ScrabbleBinary c);
}
