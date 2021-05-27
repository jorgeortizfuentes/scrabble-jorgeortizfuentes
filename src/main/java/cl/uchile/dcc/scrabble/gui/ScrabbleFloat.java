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
        double sum = c.getContent()+this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType addedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()+this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType addedByBinary(ScrabbleBinary c) {
        // pendiente
        return null;
    }

    @Override
    public ScrabbleType addedByBool(ScrabbleBoolean c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleType subtractWith(ScrabbleNumber c) {
        return c.addedByFloat(this);
    }

    @Override
    public ScrabbleType subtractedByInt(ScrabbleInt c) {
        double sum = c.getContent()-this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType subtractedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()-this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType subtractedByBinary(ScrabbleBinary c) {
        // pendiente
        return null;
    }

    @Override
    public ScrabbleType multiplyWith(ScrabbleNumber c) {
        return c.addedByFloat(this);
    }

    @Override
    public ScrabbleType multipliedByInt(ScrabbleInt c) {
        double sum = c.getContent()*this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType multipliedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()*this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType multipliedByBinary(ScrabbleBinary c) {
        // pendiente
        return null;
    }

    @Override
    public ScrabbleType divideWith(ScrabbleNumber c) {
        return c.addedByFloat(this);
    }

    @Override
    public ScrabbleType dividedByInt(ScrabbleInt c) {
        double sum = c.getContent()/this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType dividedByFloat(ScrabbleFloat c) {
        double sum = c.getContent()/this.content;
        return new ScrabbleFloat(sum);
    }

    @Override
    public ScrabbleType dividedByBinary(ScrabbleBinary c) {
        // pendiente
        return null;
    }
}
