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
        String newContent = "";
        for (int i = 0; i < this.content.length(); i++) {
            if (this.content.charAt(i) == '0'){
                newContent = newContent + "1";
            } else{
                newContent = newContent + "0";
            }

        }
        return new ScrabbleBinary(newContent);
    }

    @Override
    public ScrabbleLogic conjunctionWith(ScrabbleLogic c) {
        return c.conjunctionByBinary(this);
    }

    @Override
    public ScrabbleLogic conjunctionByBoolean(ScrabbleBoolean c) {
        // esto hay que arreglarlo
        for (int i = 0; i < this.content.length(); i++) {
            if (this.content.charAt(i) == '0' || !c.getContent()){
                return new ScrabbleBinary(this.content);
            }
        }
        //String trueString = this.content.replace("0", "1");
        return new ScrabbleBinary(this.content);
    }

    @Override
    public ScrabbleLogic conjunctionByBinary(ScrabbleBinary c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleLogic disjunctionWith(ScrabbleLogic c) {
        return c.conjunctionByBinary(this);
    }

    @Override
    public ScrabbleLogic disjunctionByBoolean(ScrabbleBoolean c) {
        boolean trueFound = false;
        for (int i = 0; i < this.content.length(); i++) {
            if (this.content.charAt(i) == '1') {
                trueFound = true;
                break;
            }
        }
        if (trueFound) {
            String trueString = this.content.replace("0", "1");
            return new ScrabbleBinary(trueString);
        } else {
            return new ScrabbleBinary(this.content);
        }
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
        int sum = binaryInt+c.getContent();
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType addedByFloat(ScrabbleFloat c) {
        // pendiente
        return null;
    }

    @Override
    public ScrabbleType addedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int sum = binaryInt1+binaryInt2;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType addedByBool(ScrabbleBoolean c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleType subtractWith(ScrabbleNumber c) {
        return c.addedByBinary(this);
    }

    @Override
    public ScrabbleType subtractedByInt(ScrabbleInt c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        int sum = c.getContent()-binaryInt;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType subtractedByFloat(ScrabbleFloat c) {
        // pendiente
        return null;
    }

    @Override
    public ScrabbleType subtractedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int sum = binaryInt2-binaryInt1;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType multiplyWith(ScrabbleNumber c) {
        return c.addedByBinary(this);
    }

    @Override
    public ScrabbleType multipliedByInt(ScrabbleInt c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        int sum = c.getContent()*binaryInt;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType multipliedByFloat(ScrabbleFloat c) {
        // pendiente
        return null;
    }

    @Override
    public ScrabbleType multipliedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int sum = binaryInt2*binaryInt1;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType divideWith(ScrabbleNumber c) {
        return c.addedByBinary(this);
    }

    @Override
    public ScrabbleType dividedByInt(ScrabbleInt c) {
        ScrabbleInt binarySInt = this.asInt();
        int binaryInt = binarySInt.getContent();
        int sum = c.getContent()/binaryInt;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType dividedByFloat(ScrabbleFloat c) {
        // pendiente
        return null;
    }

    @Override
    public ScrabbleType dividedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt1 = this.asInt();
        int binaryInt1 = binarySInt1.getContent();
        ScrabbleInt binarySInt2 = c.asInt();
        int binaryInt2 = binarySInt2.getContent();
        int sum = binaryInt2/binaryInt1;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

}


