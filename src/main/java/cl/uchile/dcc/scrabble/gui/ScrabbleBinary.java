package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScrabbleBinary implements  ScrabbleType, ScrabbleLogic, ScrabbleNumber {
    protected String content;

    public ScrabbleBinary(String javaStr){

        Pattern pattern = Pattern.compile("[^0-1]");
        Matcher matcher = pattern.matcher(javaStr);
        boolean isBinary = !matcher.find();
        if (!isBinary) throw new AssertionError("The string is not a binary.");
        this.content = javaStr;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return this.content;
    }

    @Override
    public ScrabbleString asString(){
        return new ScrabbleString(this.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBinary.class, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBinary) {
            var o = (ScrabbleBinary) obj;
            return o.getContent().equals(this.content);
        }
        return false;
    }

    public ScrabbleInt asInt(){
        int binInt = BinUtilities.toInt(this.content);
        return new ScrabbleInt(binInt);
    }

    @Override
    public ScrabbleBinary negation(){
        StringBuilder newContent = new StringBuilder();
        for (int i = 0; i < this.content.length(); i++) {
            if (this.content.charAt(i) == '0'){
                newContent.append("1");
            } else{
                newContent.append("0");
            }

        }
        return new ScrabbleBinary(newContent.toString());
    }

    @Override
    public ScrabbleLogic conjunctionWith(ScrabbleLogic c) {
        return c.conjunctionByBinary(this);
    }

    @Override
    public ScrabbleLogic conjunctionByBoolean(ScrabbleBoolean c) {
        StringBuilder newBinary = new StringBuilder();
        for (int i = 0; i < this.content.length(); i++) {
            if (this.content.charAt(i) == '0') {
                newBinary.append("0");
            } else {
                if (!c.getContent()) {
                    newBinary.append("0");
                } else {
                    newBinary.append("1");
                }
            }
        }
        return new ScrabbleBinary(newBinary.toString());
    }

    @Override
    public ScrabbleLogic conjunctionByBinary(ScrabbleBinary c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleLogic disjunctionWith(ScrabbleLogic c) {
        return c.disjunctionByBinary(this);
    }

    @Override
    public ScrabbleLogic disjunctionByBoolean(ScrabbleBoolean c) {
        StringBuilder newBinary = new StringBuilder();
        for (int i = 0; i < this.content.length(); i++) {
            if (this.content.charAt(i) == '1') {
                newBinary.append("1");
            } else {
                if (c.getContent()) {
                    newBinary.append("1");
                } else {
                    newBinary.append("0");
                }
            }
        }
        return new ScrabbleBinary(newBinary.toString());
    }

    @Override
    public ScrabbleLogic disjunctionByBinary(ScrabbleBinary c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleType addWith(ScrabbleType c) {
        return c.addedByBinary(this);
    }

    @Override
    public ScrabbleType addedByString(ScrabbleString c) {
        String addedString = c.getContent() + this.content;
        return new ScrabbleString(addedString);
    }

    @Override
    public ScrabbleType addedByInt(ScrabbleInt c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        int result = binaryInt+c.getContent();
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleType addedByFloat(ScrabbleFloat c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        double result = binaryInt+c.getContent();
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleType addedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int result = binaryInt1+binaryInt2;
        String stringBinarySum = BinUtilities.intToBinary(result);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType addedByBool(ScrabbleBoolean c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleNumber subtractWith(ScrabbleNumber c) {
        return c.subtractedByBinary(this);
    }

    @Override
    public ScrabbleNumber subtractedByInt(ScrabbleInt c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        int result = c.getContent()-binaryInt;
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleNumber subtractedByFloat(ScrabbleFloat c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        double result = c.getContent()-binaryInt;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber subtractedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int result = binaryInt2-binaryInt1;
        String stringBinarySum = BinUtilities.intToBinary(result);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleNumber multiplyWith(ScrabbleNumber c) {
        return c.multipliedByBinary(this);
    }

    @Override
    public ScrabbleNumber multipliedByInt(ScrabbleInt c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        int result = c.getContent()*binaryInt;
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleNumber multipliedByFloat(ScrabbleFloat c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        double result = c.getContent()*binaryInt;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber multipliedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int result = binaryInt2*binaryInt1;
        String stringBinarySum = BinUtilities.intToBinary(result);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleNumber divideWith(ScrabbleNumber c) {
        return c.dividedByBinary(this);
    }

    @Override
    public ScrabbleNumber dividedByInt(ScrabbleInt c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        int result = c.getContent()/binaryInt;
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleNumber dividedByFloat(ScrabbleFloat c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        double result = c.getContent()/binaryInt;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber dividedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int result = binaryInt2/binaryInt1;
        String stringBinarySum = BinUtilities.intToBinary(result);
        return new ScrabbleBinary(stringBinarySum);
    }

}


