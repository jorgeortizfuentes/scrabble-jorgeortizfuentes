package cl.uchile.dcc.scrabble.gui;

public interface ScrabbleNumber {

    ScrabbleType addWith(ScrabbleType c);
    ScrabbleType addedByString(ScrabbleString c);
    ScrabbleType addedByInt(ScrabbleInt c);
    ScrabbleType addedByFloat(ScrabbleFloat c);
    ScrabbleType addedByBinary(ScrabbleBinary c);
    ScrabbleType addedByBool(ScrabbleBoolean c);

    ScrabbleNumber subtractWith(ScrabbleNumber c);
    ScrabbleNumber subtractedByInt(ScrabbleInt c);
    ScrabbleNumber subtractedByFloat(ScrabbleFloat c);
    ScrabbleNumber subtractedByBinary(ScrabbleBinary c);

    ScrabbleNumber multiplyWith(ScrabbleNumber c);
    ScrabbleNumber multipliedByInt(ScrabbleInt c);
    ScrabbleNumber multipliedByFloat(ScrabbleFloat c);
    ScrabbleNumber multipliedByBinary(ScrabbleBinary c);

    ScrabbleNumber divideWith(ScrabbleNumber c);
    ScrabbleNumber dividedByInt(ScrabbleInt c);
    ScrabbleNumber dividedByFloat(ScrabbleFloat c);
    ScrabbleNumber dividedByBinary(ScrabbleBinary c);
}
