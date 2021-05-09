package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleFloat extends AbstractScrabbleType{
    protected double content;

    public ScrabbleFloat(double javaDouble){
        this.content = javaDouble;
    }

    public double getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return Double.toString(this.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleFloat.class);
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
