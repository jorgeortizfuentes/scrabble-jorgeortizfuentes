package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleInt implements ScrabbleType, ScrabbleNumber{
    protected int content;

    public ScrabbleInt(int javaInt){
        this.content = javaInt;
    }

    public int getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return Integer.toString(this.content);
    }

    public ScrabbleString asString(){
        String str = this.toString();
        return new ScrabbleString(str);
    }

    public ScrabbleFloat asFloat(){
        double n_float = this.content;
        return new ScrabbleFloat(n_float);
    }

    public ScrabbleInt asInt(){
        return new ScrabbleInt(this.content);
    }

    public ScrabbleBinary asBinary(){
        String b_int = BinUtilities.intToBinary(this.content);
        return new ScrabbleBinary(b_int);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleInt.class, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleInt) {
            var o = (ScrabbleInt) obj;
            return o.getContent() == this.content;
        }
        return false;
    }

    @Override
    public ScrabbleType addWith(ScrabbleType c) {
        return c.addedByInt(this);
    }

    @Override
    public ScrabbleType addedByString(ScrabbleString c) {
        String addedString = c.getContent()+this.content;
        return new ScrabbleString(addedString);
    }

    @Override
    public ScrabbleType addedByInt(ScrabbleInt c) {
        int result = c.getContent()+this.content;
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleType addedByFloat(ScrabbleFloat c) {
        double result = c.getContent()+this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleType addedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int result = binaryInt+this.content;
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
        return c.subtractedByInt(this);
    }

    @Override
    public ScrabbleNumber subtractedByInt(ScrabbleInt c) {
        int result = c.getContent()-this.content;
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleNumber subtractedByFloat(ScrabbleFloat c) {

        double subtraction = c.asFloat().getContent()-this.content;
        System.out.println(subtraction);
        return new ScrabbleFloat(subtraction);
    }

    @Override
    public ScrabbleNumber subtractedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int result = binaryInt-this.content;
        String stringBinarySum = BinUtilities.intToBinary(result);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleNumber multiplyWith(ScrabbleNumber c) {
        return c.multipliedByInt(this);
    }

    @Override
    public ScrabbleNumber multipliedByInt(ScrabbleInt c) {
        int result = c.getContent()*this.content;
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleNumber multipliedByFloat(ScrabbleFloat c) {
        double result = c.getContent()*this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber multipliedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int result = binaryInt*this.content;
        String stringBinarySum = BinUtilities.intToBinary(result);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleNumber divideWith(ScrabbleNumber c) {
        return c.dividedByInt(this);
    }

    @Override
    public ScrabbleNumber dividedByInt(ScrabbleInt c) {
        int result = Math.round(c.getContent()/this.content);
        return new ScrabbleInt(result);
    }

    @Override
    public ScrabbleNumber dividedByFloat(ScrabbleFloat c) {
        double result = c.getContent()/this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber dividedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int result = binaryInt/this.content;
        String stringBinarySum = BinUtilities.intToBinary(result);
        return new ScrabbleBinary(stringBinarySum);
    }
}
