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
        int sum = c.getContent()+this.content;
        return new ScrabbleInt(sum);
    }

    @Override
    public ScrabbleType addedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()+this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType addedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int sum = binaryInt+this.content;
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
        return c.subtractedByInt(this);
    }

    @Override
    public ScrabbleType subtractedByInt(ScrabbleInt c) {
        int sum = c.getContent()-this.content;
        return new ScrabbleInt(sum);
    }

    @Override
    public ScrabbleType subtractedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()-this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType subtractedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int sum = binaryInt-this.content;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType multiplyWith(ScrabbleNumber c) {
        return c.addedByInt(this);
    }

    @Override
    public ScrabbleType multipliedByInt(ScrabbleInt c) {
        int sum = c.getContent()*this.content;
        return new ScrabbleInt(sum);
    }

    @Override
    public ScrabbleType multipliedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()*this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType multipliedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int sum = binaryInt*this.content;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }

    @Override
    public ScrabbleType divideWith(ScrabbleNumber c) {
        return c.addedByInt(this);
    }

    @Override
    public ScrabbleType dividedByInt(ScrabbleInt c) {
        int sum = c.getContent()/this.content;
        return new ScrabbleInt(sum);
    }

    @Override
    public ScrabbleType dividedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()/this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType dividedByBinary(ScrabbleBinary c) {
        ScrabbleInt binarySInt = c.asInt();
        int binaryInt = binarySInt.getContent();
        int sum = binaryInt/this.content;
        String stringBinarySum = BinUtilities.intToBinary(sum);
        return new ScrabbleBinary(stringBinarySum);
    }
}
