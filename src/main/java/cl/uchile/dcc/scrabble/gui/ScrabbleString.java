package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleString implements ScrabbleType{
    protected String content;

    public ScrabbleString(String javaStr){
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
         return Objects.hash(ScrabbleString.class, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleString) {
            var o = (ScrabbleString) obj;
            return o.getContent().equals(this.content);

        }
        return false;
    }

    @Override
    public ScrabbleType addWith(ScrabbleType c) {
        return c.addedByString(this);
    }

    @Override
    public ScrabbleType addedByString(ScrabbleString c) {
        String addedString =  c.getContent()+ this.content;
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
