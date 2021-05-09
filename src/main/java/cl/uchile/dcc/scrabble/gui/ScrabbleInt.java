package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleInt extends AbstractScrabbleType{
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

    public double toFloat(){
        return (double) this.content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleInt.class);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleInt) {
            var o = (ScrabbleInt) obj;
            return o.getContent() == this.content;
        }
        return false;
    }
}
