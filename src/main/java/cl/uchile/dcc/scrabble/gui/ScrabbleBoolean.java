package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleBoolean implements ScrabbleType, ScrabbleLogic {
    protected boolean content;

    public ScrabbleBoolean(boolean javaBoolean){
        this.content = javaBoolean;
    }


    public boolean getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return Boolean.toString(this.content);
    }

    @Override
    public ScrabbleString asString(){
        String str = this.toString();
        return new ScrabbleString(str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBoolean.class, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBoolean) {
            var o = (ScrabbleBoolean) obj;
            return o.getContent() == this.content;

        }
        return false;
    }

    public ScrabbleBoolean asBool(){
        return new ScrabbleBoolean(this.content);
    }

    @Override
    public ScrabbleBoolean negation(){
        return new ScrabbleBoolean(!this.content);
    }

    @Override
    public ScrabbleLogic conjunctionWith(ScrabbleLogic c) {
        return c.conjunctionByBoolean(this);
    }

    @Override
    public ScrabbleLogic conjunctionByBoolean(ScrabbleBoolean c) {
        return new ScrabbleBoolean(c.getContent() && this.content);
    }

    @Override
    public ScrabbleLogic conjunctionByBinary(ScrabbleBinary c) {
        StringBuilder newBinary = new StringBuilder();
        for (int i = 0; i < c.getContent().length(); i++) {
            if (c.getContent().charAt(i) == '0') {
                newBinary.append("0");
            } else {
                if (!this.content) {
                    newBinary.append("0");
                } else {
                    newBinary.append("1");
                }
            }
        }
        return new ScrabbleBinary(newBinary.toString());
    }

    @Override
    public ScrabbleLogic disjunctionWith(ScrabbleLogic c) {
        return c.disjunctionByBoolean(this);
    }

    @Override
    public ScrabbleLogic disjunctionByBoolean(ScrabbleBoolean c) {
        return new ScrabbleBoolean(c.getContent() || this.content);
    }

    @Override
    public ScrabbleLogic disjunctionByBinary(ScrabbleBinary c) {
        StringBuilder newBinary = new StringBuilder();
        for (int i = 0; i < c.getContent().length(); i++) {
            if (c.getContent().charAt(i) == '1') {
                newBinary.append("1");
            } else {
                if (this.content) {
                    newBinary.append("1");
                } else {
                    newBinary.append("0");
                }
            }
        }
        return new ScrabbleBinary(newBinary.toString());
    }

    @Override
    public ScrabbleType addWith(ScrabbleType c) {
        return c.addedByBool(this);
    }

    @Override
    public ScrabbleType addedByString(ScrabbleString c) {
        String addedString = c.getContent() + this.content;
        return new ScrabbleString(addedString);
    }

    @Override
    public ScrabbleType addedByInt(ScrabbleInt c) {
        // Invalid operation
        return null;
    }

    @Override
    public ScrabbleType addedByFloat(ScrabbleFloat c) {
        // Invalid operation
        return null;
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
}