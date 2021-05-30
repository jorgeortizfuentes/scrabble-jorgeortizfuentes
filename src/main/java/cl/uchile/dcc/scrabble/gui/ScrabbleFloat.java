package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleFloat implements ScrabbleType, ScrabbleNumber {
    protected double content;

    public ScrabbleFloat(double javaDouble){
        this.content = javaDouble;
    }

    @Override
    public String toString(){
        return Double.toString(this.content);
    }

    public double getContent() {
        return this.content;
    }

    public ScrabbleFloat asFloat() {
        return new ScrabbleFloat(this.content);
    }

    public ScrabbleString asString(){
        String str = this.toString();
        return new ScrabbleString(str);

    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleFloat.class, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleFloat) {
            var o = (ScrabbleFloat) obj;
            return o.getContent() == this.content;
        }
        return false;
    }

    @Override
    public ScrabbleType addWith(ScrabbleType c) {
        return c.addedByFloat(this);
    }

    @Override
    public ScrabbleType addedByString(ScrabbleString c) {
        String addedString = c.getContent() + this.content;
        return new ScrabbleString(addedString);
    }

    @Override
    public ScrabbleType addedByInt(ScrabbleInt c) {
        double result = c.getContent()+this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleType addedByFloat(ScrabbleFloat c) {
        double result = c.getContent()+this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleType addedByBinary(ScrabbleBinary c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleType addedByBool(ScrabbleBoolean c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleNumber subtractWith(ScrabbleNumber c) {
        return c.subtractedByFloat(this);
    }

    @Override
    public ScrabbleNumber subtractedByInt(ScrabbleInt c) {
        return c.asFloat().subtractWith(this);
    }

    @Override
    public ScrabbleNumber subtractedByFloat(ScrabbleFloat c) {
        double result = c.getContent()-this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber subtractedByBinary(ScrabbleBinary c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleNumber multiplyWith(ScrabbleNumber c) {
        return c.multipliedByFloat(this);
    }

    @Override
    public ScrabbleNumber multipliedByInt(ScrabbleInt c) {
        double result = c.getContent()*this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber multipliedByFloat(ScrabbleFloat c) {
        double result = c.getContent()*this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber multipliedByBinary(ScrabbleBinary c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleNumber divideWith(ScrabbleNumber c) {
        return c.dividedByFloat(this);
    }

    @Override
    public ScrabbleNumber dividedByInt(ScrabbleInt c) {
        double result = c.getContent()/this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber dividedByFloat(ScrabbleFloat c) {
        double result = c.getContent()/this.content;
        return new ScrabbleFloat(result);
    }

    @Override
    public ScrabbleNumber dividedByBinary(ScrabbleBinary c) {
        // Invalid operation
        return null;
    }
}
