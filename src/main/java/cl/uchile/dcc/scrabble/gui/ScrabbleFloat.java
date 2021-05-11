package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleFloat extends AbstractScrabbleType{
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
}
